package models

abstract class Autobus() {
    private var ID = 0
    private var conductor: Conductor = Conductor()
    private var preuBase = 0.0

    //GETTERS I SETTERS
    fun getPreuBase(): Double{
        return preuBase
    }
    fun setPreuBase(preuBase: Double){
        this.preuBase = preuBase
    }

    fun getConductor(): Conductor{
        return conductor
    }
    fun setConductor(conductor: Conductor) {
        this.conductor = conductor
    }

    fun getID() : Int{
        return ID
    }
    fun setID(ID: Int) {
        this.ID = ID
    }

    abstract fun calcularPreu(): Double

    //Constructor
    constructor(ID: Int, conductor: Conductor, preuBase: Double): this(){
        this.ID = ID
        this.conductor = conductor
        this.preuBase = preuBase
    }

    //Overrite
    override fun toString() : String {
        return "Los datos de los autobuses -> ${getID()}, ${getConductor()}, ${getPreuBase()}"
    }
}