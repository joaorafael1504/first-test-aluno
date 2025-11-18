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
        Media media = Media.of(8.5);
        assertNotNull(media.hashCode());
        assertEquals("8.5", media.toString());
    }

    @Test
    void testEqualsEdgeCases() {
        Media media = Media.of(8.0);
        assertTrue(media.equals(Media.of(8.0)));
        assertFalse(media.equals(null));
        assertFalse(media.equals(new Object()));
        assertFalse(media.equals(Media.of(9.0)));
    }
    
    @Test
    void testMediaInvalidaNaN() {
        assertThrows(IllegalArgumentException.class, () -> {
            Media.of(Double.NaN);
        });
    }

    @Test
    void testEqualsComMesmaInstancia() {
        Media media = Media.of(5.0);
        assertTrue(media.equals(media)); 
    }
}