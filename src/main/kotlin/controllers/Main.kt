package org.example.controllers

import models.*
import java.util.Scanner

/**
 * Punto de entrada principal de la aplicación
 * inicializa el scanner, listas de autobuses y conductores,
 * y lanza el menú principal
 * @author William Guzman
 */
fun main() {
    val scan = abrirScanner()
    val busos = mutableListOf<Autobus>()
    val conductors = mutableListOf<Conductor>()
    menu(scan, busos, conductors)
    cerrarScanner(scan)
}

/**
 * Menú principal de la aplicación
 * permite comprar billetes, gestionar autobuses y conductores o salir
 *
 * @param scan scanner para entrada de usuario
 * @param busos lista mutable de autobuses
 * @param conductors lista mutable de conductores
 */
fun menu(scan: Scanner, busos: MutableList<Autobus>, conductors: MutableList<Conductor>) {
    var opcion: Int
    do {
        mostrarMenu()
        opcion = scan.nextInt()
        when (opcion) {
            1 -> comprarBillete(busos)
            2 -> menuAdmin(scan, busos, conductors)
            3 -> println("saliendo...")
            else -> println("opción inválida")
        }
    } while (opcion != 3)
}

/**
 * Menú para gestionar conductores y autobuses
 *
 * @param scan scanner para entrada de usuario
 * @param busos lista mutable de autobuses
 * @param conductors lista mutable de conductores
 */
fun menuAdmin(scan: Scanner, busos: MutableList<Autobus>, conductors: MutableList<Conductor>) {
    var opcion = 0
    do {
        mostrarMenuAdmin()
        opcion = scan.nextInt()
        when (opcion) {
            1 -> conductors.add(altaConductor(scan))
            2 -> altaBus(scan, busos)
            3 -> listarBuses(busos)
            4 -> listarConductores(conductors)
        }
    } while (opcion != 5)
}

/**
 * Permite comprar un billete mostrando los autobuses disponibles
 *
 * @param busos lista mutable de autobuses disponibles
 */
fun comprarBillete(busos: MutableList<Autobus>) {
    if (busos.isEmpty()) println("no hay autobuses disponibles")
    else {
        println("autobuses disponibles:")
        busos.forEachIndexed { i, bus ->
            println("${i + 1}) id=${bus.getID()} conductor=${bus.getConductor().getNom()} precio=${bus.calcularPreu()}")
        }
    }
}

/**
 * da de alta un nuevo conductor solicitando datos por consola
 *
 * @param scan scanner para entrada de usuario
 * @return nuevo objeto conductor creado
 */
fun altaConductor(scan: Scanner): Conductor {
    println("--datos conductor--")
    print("nombre: ")
    val nombre = scan.next()
    print("salario: ")
    val salario = scan.nextDouble()
    return Conductor(nombre, salario)
}

/**
 * da de alta un nuevo autobús urbano o interurbano
 *
 * @param scan scanner para entrada de usuario
 * @param busos lista mutable de autobuses donde se añadirá el nuevo
 */
fun altaBus(scan: Scanner, busos: MutableList<Autobus>) {
    println("""
        1 - urbano
        2 - interurbano
        """.trimIndent())
    val tipo = scan.nextInt()
    print("id: ")
    val id = scan.nextInt()
    val conductor = altaConductor(scan)
    print("precio base: ")
    val precioBase = scan.nextDouble()
    if (tipo == 1) {
        print("ruta: ")
        busos.add(AutobusUrbans(id, conductor, precioBase, scan.next()))
    } else {
        print("km: ")
        busos.add(AutobusInterurbans(id, conductor, precioBase, scan.nextDouble()))
    }
}

/**
 * Lista todos los autobuses disponibles
 *
 * @param busos lista de autobuses
 */
fun listarBuses(busos: MutableList<Autobus>) {
    if (busos.isEmpty()) println("no hay autobuses disponibles")
    else busos.forEach { println(it) }
}

/**
 * Lista todos los conductores disponibles
 *
 * @param conductors lista de conductores
 */
fun listarConductores(conductors: MutableList<Conductor>) {
    if (conductors.isEmpty()) println("no hay conductores disponibles")
    else conductors.forEach { println(it) }
}

/** Muestra texto del menú principal */
fun mostrarMenu() {
    println("""
            1 - comprar billete
            2 - gestionar
            3 - salir
        """.trimIndent())
}

/** Muestra texto del menú administrativo */
fun mostrarMenuAdmin() {
    println("""
        1 - alta de conductores
        2 - alta de autobuses
        3 - listar buses
        4 - listar conductores
        5 - volver
        """.trimIndent())
}

/** Abre el scanner para entrada estándar */
fun abrirScanner(): Scanner {
    return Scanner(System.`in`)
}

/** Cierra el scanner */
fun cerrarScanner(scan: Scanner) {
    scan.close()
}
