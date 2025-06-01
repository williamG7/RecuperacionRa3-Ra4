package controllers

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import models.Conductor

class ConductorTest{

    @Test
    fun testCrearConductor() {
        val conductor = Conductor("Juan", 1500.0)
        assertEquals("Juan", conductor.getNom())
        assertEquals(1500.0, conductor.getSalari())
    }

    @Test
    fun testModificarConductor() {
        val conductor = Conductor()
        conductor.setNom("Ana")
        conductor.setSalari(2000.0)
        assertEquals("Ana", conductor.getNom())
        assertEquals(2000.0, conductor.getSalari())
    }

    @Test
    fun testObtenerConductor() {
        val conductor = Conductor("Ana", 2500.0)
        assertEquals("Ana", conductor.getNom(), "El nombre obtenido debe ser Ana")
        assertEquals(2500.0, conductor.getSalari(), "El salario obtenido debe ser 2500.0")
    }


}