package aluno_ac2.ac2_ca.domain.test;

import aluno_ac2.ac2_ca.domain.CursosConcluidos;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CursosConcluidosTest {

    @Test
    void testCriacaoValida() {
        assertDoesNotThrow(() -> CursosConcluidos.of(0));
        assertDoesNotThrow(() -> CursosConcluidos.of(15));
    }

    @Test
    void testCriacaoInvalida() {
        assertThrows(IllegalArgumentException.class, () -> {
            CursosConcluidos.of(-1);
        });
    }

    @Test
    void testIsAtLeast() {
        CursosConcluidos cursos = CursosConcluidos.of(12);
        assertTrue(cursos.isAtLeast(10));
        assertTrue(cursos.isAtLeast(12));
        assertFalse(cursos.isAtLeast(13));
    }
    
    @Test
    void testIncrement() {
        CursosConcluidos cursos = CursosConcluidos.of(10);
        CursosConcluidos maisUm = cursos.increment();
        assertEquals(11, maisUm.value());
    }

    @Test
    void testHashCodeEToString() {
        CursosConcluidos cursos = CursosConcluidos.of(10);
        assertNotNull(cursos.hashCode());
        assertEquals("10", cursos.toString());
    }

    @Test
    void testEqualsEdgeCases() {
        CursosConcluidos cursos = CursosConcluidos.of(10);
        assertTrue(cursos.equals(CursosConcluidos.of(10)));
        assertFalse(cursos.equals(null));
        assertFalse(cursos.equals(new Object()));
        assertFalse(cursos.equals(CursosConcluidos.of(9)));
    }
    
    @Test
    void testEqualsComMesmaInstancia() {
        CursosConcluidos cursos = CursosConcluidos.of(5);
        assertTrue(cursos.equals(cursos)); 
    }
}