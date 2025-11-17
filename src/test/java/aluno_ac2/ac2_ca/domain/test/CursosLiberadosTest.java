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
        // Deve lançar exceção se for negativo
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
        // Testa a linha vermelha do 'add()'
        CursosLiberados cursos = CursosLiberados.of(5);
        CursosLiberados maisDois = cursos.add(2);
        assertEquals(7, maisDois.value());
    }

    @Test
    void testAddInvalido() {
        // Testa a branch de exceção do 'add()'
        CursosLiberados cursos = CursosLiberados.of(5);
        assertThrows(IllegalArgumentException.class, () -> cursos.add(-1));
    }

    @Test
    void testHashCodeEToString() {
        // Testa as linhas vermelhas de hashCode() e toString()
        CursosLiberados cursos = CursosLiberados.of(10);
        assertNotNull(cursos.hashCode());
        assertEquals("10", cursos.toString());
    }

    @Test
    void testEqualsEdgeCases() {
        // Testa os caminhos amarelos (branches) do 'equals()'
        CursosLiberados cursos = CursosLiberados.of(3);
        assertTrue(cursos.equals(CursosLiberados.of(3)));
        assertFalse(cursos.equals(null));
        assertFalse(cursos.equals(new Object()));
        assertFalse(cursos.equals(CursosLiberados.of(1)));
    }
    
    @Test
    void testEqualsComMesmaInstancia() {
        CursosLiberados cursos = CursosLiberados.of(3);
        
        // Testa a branch 'this == o'
        assertTrue(cursos.equals(cursos)); 
    }
}