package models

/**
 * Clase abstracta que representa un autobús
 *
 * @property ID Identificador único del autobús
 * @property conductor Conductor asignado al autobús
 * @property preuBase Precio base asociado al autobús
 * @author William Guzman
 */
abstract class Autobus() {
    private var ID = 0
    private var conductor: Conductor = Conductor()
    private var preuBase = 0.0

    /**
     * Obtiene el precio base del autobús
     * @return Precio base como Double
     */
    fun getPreuBase(): Double {
        return preuBase
    }

    /**
     * Establece el precio base del autobús
     * @param preuBase Precio base a asignar
     */
    fun setPreuBase(preuBase: Double) {
        this.preuBase = preuBase
    }

    /**
     * Obtiene el conductor asignado al autobús
     * @return Objeto de tipo Conductor
     */
    fun getConductor(): Conductor {
        return conductor
    }

    /**
     * Asigna un conductor al autobús
     * @param conductor Objeto de tipo Conductor a asignar
     */
    fun setConductor(conductor: Conductor) {
        this.conductor = conductor
    }

    /**
     * Obtiene el identificador del autobús
     * @return Identificador como entero
     */
    fun getID(): Int {
        return ID
    }

    /**
     * Establece el identificador del autobús
     * @param ID Identificador a asignar
     */
    fun setID(ID: Int) {
        this.ID = ID
    }

    /**
     * Método abstracto para calcular el precio del billete del autobús
     * Debe ser implementado en las clases derivadas
     *
     * @return Precio calculado como Double
     */
    abstract fun calcularPreu(): Double

    /**
     * Constructor con parámetros para inicializar el autobús
     *
     * @param ID Identificador único
     * @param conductor Conductor asignado
     * @param preuBase Precio base del autobús
     */
    constructor(ID: Int, conductor: Conductor, preuBase: Double) : this() {
        this.ID = ID
        this.conductor = conductor
        this.preuBase = preuBase
    }

    /**
     * Representación en cadena del autobús
     *
     * @return String con los datos del autobús
     */
    override fun toString(): String {
        return "Los datos de los autobuses -> ${getID()}, ${getConductor()}, ${getPreuBase()}"
    }
}
