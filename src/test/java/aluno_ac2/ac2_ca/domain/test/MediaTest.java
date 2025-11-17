package aluno_ac2.ac2_ca.domain.test;

import aluno_ac2.ac2_ca.domain.Media;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MediaTest {
    @Test
    void testMediaValida() {
        assertDoesNotThrow(() -> Media.of(0.0));
        assertDoesNotThrow(() -> Media.of(10.0));
    }

    @Test
    void testMediaInvalida() {
        assertThrows(IllegalArgumentException.class, () -> Media.of(-0.1));
        assertThrows(IllegalArgumentException.class, () -> Media.of(10.1));
    }
    
    @Test
    void testHashCodeEToString() {
        // Testa as linhas vermelhas de hashCode() e toString()
        Media media = Media.of(8.5);
        assertNotNull(media.hashCode());
        assertEquals("8.5", media.toString());
    }

    @Test
    void testEqualsEdgeCases() {
        // Testa os caminhos amarelos (branches) do 'equals()'
        Media media = Media.of(8.0);
        
        // Testa contra um objeto do mesmo valor
        assertTrue(media.equals(Media.of(8.0)));
        
        // Testa contra nulo
        assertFalse(media.equals(null));
        
        // Testa contra um tipo de classe diferente
        assertFalse(media.equals(new Object()));
        
        // Testa contra um valor diferente
        assertFalse(media.equals(Media.of(9.0)));
    }
    
    @Test
    void testMediaInvalidaNaN() {
        // Testa a branch 'Double.isNaN' da Linha 13
        assertThrows(IllegalArgumentException.class, () -> {
            Media.of(Double.NaN);
        });
    }

    @Test
    void testEqualsComMesmaInstancia() {
        Media media = Media.of(5.0);
        
        // Testa a branch 'this == o' da Linha 29
        assertTrue(media.equals(media)); 
    }
}