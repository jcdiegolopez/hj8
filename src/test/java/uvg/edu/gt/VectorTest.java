package uvg.edu.gt;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class VectorTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test

    public void testCompareTo() {
        // Crear instancias de pacientes con diferentes prioridades
        Paciente paciente1 = new Paciente("Juan", "Dolor de cabeza", "B");
        Paciente paciente2 = new Paciente("María", "Fiebre", "A");
        Paciente paciente3 = new Paciente("Pedro", "Dolor de garganta", "C");

        // Verificar la comparación entre las prioridades
        assertEquals("El paciente con prioridad 'A' debe ser mayor", 1, paciente1.compareTo(paciente2));
        assertEquals("El paciente con prioridad 'B' debe ser menor", -1, paciente1.compareTo(paciente3));
        assertEquals("El paciente con prioridad 'C' debe ser igual", 0, paciente3.compareTo(paciente3));
    }
}
