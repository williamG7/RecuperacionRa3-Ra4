package models

class Conductor() {
    private var nom = ""
    private var salari = 0.0

    //Getters i setters
    fun getNom() : String {
        return nom
    }
    fun setNom(nom : String) {
        this.nom = nom
    }

    fun getSalari() : Double {
        return salari
    }
    fun setSalari(salari : Double) {
        this.salari = salari
    }

    //Constructor
    constructor(nom : String, salari: Double): this() {
        this.salari = salari
        this.nom = nom
    }

    //Override
    override fun toString(): String {
        return "El conductor -> ${getNom()}, ${getSalari()}"
    }
}