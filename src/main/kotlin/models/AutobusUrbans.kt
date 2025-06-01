package models

/**
 * Representa un autobús urbano.
 * Hereda de la clase abstracta [Autobus].
 *
 * @property ruta Identificador de la ruta del autobús (por ejemplo, "A").
 */
class AutobusUrbans : Autobus {
    private var ruta = ""

    /**
     * Obtiene la ruta del autobús.
     * @return La ruta como String.
     */
    fun getRuta(): String {
        return ruta
    }

    /**
     * Establece la ruta del autobús.
     * @param ruta Ruta a asignar.
     */
    fun setRuta(ruta: String) {
        this.ruta = ruta
    }

    /**
     * Constructor para crear un autobús urbano.
     *
     * @param ID Identificador único del autobús.
     * @param conductor Conductor asignado al autobús.
     * @param preuBase Precio base del billete.
     * @param ruta Identificador de la ruta.
     */
    constructor(ID: Int, conductor: Conductor, preuBase: Double, ruta: String) : super(ID, conductor, preuBase) {
        this.ruta = ruta
    }

    /**
     * Calcula el precio del billete para el autobús urbano.
     * El cálculo depende de la ruta:
     * - Si la ruta es "A", el precio base aumenta un 10%.
     * - En caso contrario, aumenta un 20%.
     *
     * @return Precio calculado como Double.
     */
    override fun calcularPreu(): Double {
        val preu = if (getRuta() == "A") {
            getPreuBase() + (getPreuBase() * 0.10)
        } else {
            getPreuBase() + (getPreuBase() * 0.20)
        }
        return preu
    }

    /**
     * Representación en cadena del autobús urbano.
     *
     * @return String con los datos del autobús y la ruta.
     */
    override fun toString(): String {
        return "${super.toString()} i la seva ruta es -> ${getRuta()}"
    }
}
