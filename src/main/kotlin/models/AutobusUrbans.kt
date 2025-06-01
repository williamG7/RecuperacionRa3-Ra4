package models

class AutobusUrbans:Autobus {
    private var ruta = ""

    //GETTERS I SETTERS
    fun getRuta():String{
        return ruta
    }
    fun setRuta(ruta: String) {
        this.ruta = ruta
    }

    //Constructor
    constructor(ID: Int, conductor: Conductor, preuBase: Double, ruta: String): super(ID, conductor, preuBase){
        this.ruta = ruta
    }

    //Funcio per al calcul del preu
    override fun calcularPreu(): Double{
        var preu = if (getRuta() == "A"){
            getPreuBase()+(getPreuBase()*0.10)
        } else getPreuBase()+(getPreuBase()*0.20)
        return preu
    }

    //Override
    override fun toString(): String {
        return "${super.toString()} i la seva ruta es -> ${getRuta()}"
    }
}