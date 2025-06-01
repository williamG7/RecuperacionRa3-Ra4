package org.example.controllers

import models.*
import java.util.Scanner

/**
 * Punto de entrada principal de la aplicación
 * inicializa el scanner, listas de autobuses y conductores,
 * y lanza el menú principal
 * @author William Guzman
 */
fun main(){
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
    var opcio: Int
    do {
        menuText()
        opcio = scan.nextInt()
        when(opcio){
            1 -> comprarBitllet(busos)
            2 -> menuAdmin(scan, busos, conductors)
            3 -> println("Sortint...")
            else -> println("Opció invàlida")
        }
    } while(opcio != 3)
}

/**
 * Menú para gestionar conductores y autobuses
 *
 * @param scan scanner para entrada de usuario
 * @param busos lista mutable de autobuses
 * @param conductors lista mutable de conductores
 */
fun menuAdmin(scan:Scanner, busos: MutableList<Autobus>, conductors: MutableList<Conductor>) {
    var opcio = 0
    do {
        menuTextAdmin()
        opcio = scan.nextInt()
        when(opcio){
            1 -> conductors.add(altaCond(scan))
            2 -> altaBus(scan, busos)
            3 -> listBus(busos)
            4 -> listCond(conductors)
        }
    }
    while(opcio !=5)

}

/**
 * Permite comprar un bitllet mostrando los autobuses disponibles
 *
 * @param busos lista mutable de autobuses disponibles
 */
fun comprarBitllet(busos: MutableList<Autobus>) {
    if(busos.isEmpty()) println("No hi han autobusos disponibles")
    else {
        println("Busos disponibles:")
        busos.forEachIndexed{
                i,bus-> println("${i+1}) ID=${bus.getID()} Conductor=${bus.getConductor().getNom()} Preu=${bus.calcularPreu()}")
        }
    }
}

/**
 * Da de alta un nuevo conductor solicitando datos por consola
 *
 * @param scan scanner para entrada de usuario
 * @return nuevo objeto Conductor creado
 */
fun altaCond(scan:Scanner):Conductor {
    println("--Datos conductor--")
    print("Nom: ")
    val nom = scan.next()
    print("Salario: ")
    val salario = scan.nextDouble()
    return Conductor(nom,salario)
}

/**
 * Da de alta un nuevo autobús urbano o interurbano
 *
 * @param scan scanner para entrada de usuario
 * @param busos lista mutable de autobuses donde se añadirá el nuevo
 */
fun altaBus(scan:Scanner, busos: MutableList<Autobus>) {
    println(""" 
        1 - Urba 
        2 - Inter
        """.trimIndent())
    val t=scan.nextInt()
    print("ID: ")
    val id=scan.nextInt()
    val conductor= altaCond(scan)
    print("PreuBase: ")
    val p=scan.nextDouble()
    if(t==1){ print("Ruta: ")
        busos.add(AutobusUrbans(id,conductor,p,scan.next()))
    }else{ print("Km: ")
        busos.add(AutobusInterurbans(id,conductor,p,scan.nextDouble()))
    }
}

/**
 * Lista todos los autobuses disponibles
 *
 * @param busos lista de autobuses
 */
fun listBus(busos: MutableList<Autobus>){
    if(busos.isEmpty()) println("No hi han autobusos disponibles")
    else busos.forEach{println(it)}
}

/**
 * Lista todos los conductores disponibles
 *
 * @param conductors lista de conductores
 */
fun listCond(conductors: MutableList<Conductor>){
    if(conductors.isEmpty()) println("No hi han conductors disponibles")
    else conductors.forEach{println(it)}
}

/** Muestra texto del menú principal */
fun menuText(){
    println("""
            1 - Comprar bitllet
            2 - Gestionar
            3 - Sortir
        """.trimIndent())
}

/** Muestra texto del menú administrativo */
fun menuTextAdmin(){
    println("""
        1 - Alta de conductors
        2 - Alta d'autobusos
        3 - Llistar busos
        4 - Llistar Conductors 
        5 - Enrere""".trimIndent())
}

/** Abre el scanner para entrada estándar */
fun abrirScanner(): Scanner{
    val scan = Scanner(System.`in`)
    return scan
}

/** Cierra el scanner */
fun cerrarScanner(scan: Scanner){
    scan.close()
}
