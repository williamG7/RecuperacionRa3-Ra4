package controllers

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import models.*


class AutobusUrbansTest {

    @Test
    fun testCrearAutobusUrbans() {
        val conductor = Conductor("Maria", 1700.0)
        val bus = AutobusUrbans(10, conductor, 90.0, "C")
        assertEquals(10, bus.getID())
        assertEquals(conductor, bus.getConductor())
        assertEquals(90.0, bus.getPreuBase())
        assertEquals("C", bus.getRuta())
    }

    @Test
    fun testModificarAutobusUrbans() {
        val conductorInicial = Conductor("Juan", 1000.0)
        val bus = AutobusUrbans(0, conductorInicial, 0.0, "")
        val nuevoConductor = Conductor("Jorge", 2100.0)

        bus.setID(11)
        bus.setConductor(nuevoConductor)
        bus.setPreuBase(110.0)
        bus.setRuta("B")

        assertEquals(11, bus.getID())
        assertEquals(nuevoConductor, bus.getConductor())
        assertEquals(110.0, bus.getPreuBase())
        assertEquals("B", bus.getRuta())
    }

    @Test
    fun testCalcularPreuRutaA() {
        val bus = AutobusUrbans(13, Conductor("Pepe", 1500.0), 100.0, "A")
        val precioEsperado = 100.0 * 1.10
        assertEquals(precioEsperado, bus.calcularPreu(), 0.0001)
    }

}



