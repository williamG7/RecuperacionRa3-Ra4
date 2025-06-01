package models

/**
 * Representa un conductor.
 *
 * @property nom Nombre del conductor.
 * @property salari Salario del conductor.
 */
class Conductor() {
    private var nom = ""
    private var salari = 0.0

    /**
     * Obtiene el nombre del conductor.
     * @return Nombre como String.
     */
    fun getNom(): String {
        return nom
    }

    /**
     * Establece el nombre del conductor.
     * @param nom Nombre a asignar.
     */
    fun setNom(nom: String) {
        this.nom = nom
    }

    /**
     * Obtiene el salario del conductor.
     * @return Salario como Double.
     */
    fun getSalari(): Double {
        return salari
    }

    /**
     * Establece el salario del conductor.
     * @param salari Salario a asignar.
     */
    fun setSalari(salari: Double) {
        this.salari = salari
    }

    /**
     * Constructor para crear un conductor con nombre y salario.
     *
     * @param nom Nombre del conductor.
     * @param salari Salario del conductor.
     */
    constructor(nom: String, salari: Double) : this() {
        this.nom = nom
        this.salari = salari
    }

    /**
     * Representación en cadena del conductor.
     * @return String con el nombre y salario.
     */
    override fun toString(): String {
        return "El conductor -> ${getNom()}, ${getSalari()}"
    }
}
