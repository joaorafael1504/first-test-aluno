package aluno_ac2.ac2_ca.entity.converters.test;

import aluno_ac2.ac2_ca.domain.Plano;
import aluno_ac2.ac2_ca.entity.converters.PlanoConverter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlanoConverterTest {

    private PlanoConverter converter = new PlanoConverter();

    @Test
    void testConversaoNormal() {
        assertEquals("Premium", converter.convertToDatabaseColumn(Plano.PREMIUM));
        assertEquals(Plano.BASICO, converter.convertToEntityAttribute("Básico"));
    }

    @Test
    void testCaminhosNulos() {
        assertNull(converter.convertToDatabaseColumn(null));
        assertNull(converter.convertToEntityAttribute(null));
    }
}