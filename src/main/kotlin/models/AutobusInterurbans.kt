package models

/**
 * Representa un autobús interurbano.
 * Hereda de la clase abstracta [Autobus].
 *
 * @property quilometres Distancia en kilómetros que recorre el autobús.
 */
class AutobusInterurbans : Autobus {
    private var quilometres = 0.0

    /**
     * Obtiene los kilómetros recorridos.
     * @return Distancia en kilómetros como Double.
     */
    fun getQuilometres(): Double {
        return quilometres
    }

    /**
     * Establece la distancia en kilómetros.
     * @param quilometres Distancia a asignar.
     */
    fun setQuilometres(quilometres: Double) {
        this.quilometres = quilometres
    }

    /**
     * Constructor para crear un autobús interurbano.
     *
     * @param ID Identificador único del autobús.
     * @param conductor Conductor asignado al autobús.
     * @param preuBase Precio base del billete.
     * @param quilometres Distancia en kilómetros que recorrerá el autobús.
     */
    constructor(ID: Int, conductor: Conductor, preuBase: Double, quilometres: Double)
            : super(ID, conductor, preuBase) {
        this.quilometres = quilometres
    }

    /**
     * Calcula el precio del billete para el autobús interurbano.
     * El precio es el producto del precio base por los kilómetros recorridos.
     *
     * @return Precio calculado como Double.
     */
    override fun calcularPreu(): Double {
        return super.getPreuBase() * this.getQuilometres()
    }

    /**
     * Representación en cadena del autobús interurbano.
     *
     * @return String con los datos del autobús y los kilómetros.
     */
    override fun toString(): String {
        return "${super.toString()} i els seus quilometres ${getQuilometres()}"
    }
}
