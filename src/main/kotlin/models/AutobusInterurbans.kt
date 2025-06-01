package models

class AutobusInterurbans: Autobus {
    private var quilometres = 0.0

   //GETTERS I SETTERS
   fun getQuilometres(): Double{
       return quilometres
   }
    fun setQuilometres(quilometres: Double) {
        this.quilometres = quilometres
    }

    //CONSTRUCTORS
    constructor(ID: Int, conductor: Conductor, preuBase: Double, quilometres: Double): super(ID, conductor, preuBase){
        this.quilometres = quilometres
    }

    //Funcio per al calcul de preu del bus interurban
    override fun calcularPreu() : Double {
        return super.getPreuBase() * this.getQuilometres()
    }

    //Override
    override fun toString(): String {
        return "${super.toString()} i els seus quilometres ${getQuilometres()}"
    }
}