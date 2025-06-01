package org.example.controllers

import models.*
import java.util.Scanner

fun main(){
    val scan = abrirScanner()
    val busos = mutableListOf<Autobus>()
    val conductors = mutableListOf<Conductor>()
    menu(scan, busos, conductors)
    cerrarScanner(scan)
}

//menú principal
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

//menú per gestionar
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

//comprar un bitllet, mostra el id, el conductor i el preu corresponent
fun comprarBitllet(busos: MutableList<Autobus>) {
    if(busos.isEmpty()) println("No hi han autobusos disponibles")
    else {
        println("Busos disponibles:")
        busos.forEachIndexed{
        i,bus-> println("${i+1}) ID=${bus.getID()} Conductor=${bus.getConductor().getNom()} Preu=${bus.calcularPreu()}")
        }
    }
}

//donar de alta a un conductor
fun altaCond(scan:Scanner):Conductor {
    println("--Datos conductor--")
    print("Nom: ")
    val nom = scan.next()
    print("Salario: ")
    val salario = scan.nextDouble()
    return Conductor(nom,salario)
}

//donar de alta a un autobus
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

//llistar els busos
fun listBus(busos: MutableList<Autobus>){
    if(busos.isEmpty()) println("No hi han autobusos disponibles")
    else busos.forEach{println(it)}
}
//llista els conductors
fun listCond(conductors: MutableList<Conductor>){
    if(conductors.isEmpty()) println("No hi han conductors disponibles")
    else conductors.forEach{println(it)}
}

//text pels menus
fun menuText(){
    println("""
            1 - Comprar bitllet
            2 - Gestionar
            3 - Sortir
        """.trimIndent())
}

fun menuTextAdmin(){
    println("""
        1 - Alta de conductors
        2 - Alta d'autobusos
        3 - Llistar busos
        4 - Llistar Conductors 
        5 - Enrere""".trimIndent())
}


fun abrirScanner(): Scanner{
    val scan = Scanner(System.`in`)
    return scan
}

fun cerrarScanner(scan: Scanner){
    scan.close()
}