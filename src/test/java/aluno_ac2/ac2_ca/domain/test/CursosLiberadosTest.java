package aluno_ac2.ac2_ca.domain.test;

import aluno_ac2.ac2_ca.domain.CursosLiberados;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CursosLiberadosTest {

    @Test
    void testCriacaoValida() {
        assertDoesNotThrow(() -> CursosLiberados.of(0));
        assertDoesNotThrow(() -> CursosLiberados.of(3));
    }

    @Test
    void testCriacaoInvalida() {
        assertThrows(IllegalArgumentException.class, () -> {
            CursosLiberados.of(-1);
        });
    }

    @Test
    void testIsZero() {
        CursosLiberados cursosZero = CursosLiberados.of(0);
        CursosLiberados cursosNaoZero = CursosLiberados.of(3);
        assertTrue(cursosZero.isZero());
        assertFalse(cursosNaoZero.isZero());
    }
    
    @Test
    void testAdd() {
        CursosLiberados cursos = CursosLiberados.of(5);
        CursosLiberados maisDois = cursos.add(2);
        assertEquals(7, maisDois.value());
    }

    @Test
    void testAddInvalido() {
        CursosLiberados cursos = CursosLiberados.of(5);
        assertThrows(IllegalArgumentException.class, () -> cursos.add(-1));
    }

    @Test
    void testHashCodeEToString() {
        CursosLiberados cursos = CursosLiberados.of(10);
        assertNotNull(cursos.hashCode());
        assertEquals("10", cursos.toString());
    }

    @Test
    void testEqualsEdgeCases() {
        CursosLiberados cursos = CursosLiberados.of(3);
        assertTrue(cursos.equals(CursosLiberados.of(3)));
        assertFalse(cursos.equals(null));
        assertFalse(cursos.equals(new Object()));
        assertFalse(cursos.equals(CursosLiberados.of(1)));
    }
    
    @Test
    void testEqualsComMesmaInstancia() {
        CursosLiberados cursos = CursosLiberados.of(3);
        assertTrue(cursos.equals(cursos)); 
    }
}