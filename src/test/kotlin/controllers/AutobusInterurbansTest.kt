package controllers

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import models.*

class AutobusInterurbansTest {

    @Test
    fun testCrearAutobusInterurbans() {
        val conductor = Conductor("William", 1800.0)
        val bus = AutobusInterurbans(5, conductor, 2.5, 40.0)
        assertEquals(5, bus.getID())
        assertEquals(conductor, bus.getConductor())
        assertEquals(2.5, bus.getPreuBase())
        assertEquals(40.0, bus.getQuilometres())
    }

    @Test
    fun testModificarAutobusInterurbans() {
        val conductorInicial = Conductor("william", 1500.0)
        val bus = AutobusInterurbans(1, conductorInicial, 3.0, 50.0)

        val nuevoConductor = Conductor("Santiago", 2200.0)
        bus.setID(2)
        bus.setConductor(nuevoConductor)
        bus.setPreuBase(4.0)
        bus.setQuilometres(60.0)

        assertEquals(2, bus.getID())
        assertEquals(nuevoConductor, bus.getConductor())
        assertEquals(4.0, bus.getPreuBase())
        assertEquals(60.0, bus.getQuilometres())

        val precioEsperado = 4.0 * 60.0
        assertEquals(precioEsperado, bus.calcularPreu(), 0.0001)
    }

    @Test
    fun testCalcularPreu() {
        val bus = AutobusInterurbans(5, Conductor("Juan", 1600.0), 2.5, 40.0)
        val precioEsperado = 2.5 * 40.0
        assertEquals(precioEsperado, bus.calcularPreu(), 0.0001)
    }

}