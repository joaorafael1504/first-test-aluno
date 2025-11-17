package aluno_ac2.ac2_ca.entity.converters.test;

import aluno_ac2.ac2_ca.domain.CursosLiberados;
import aluno_ac2.ac2_ca.entity.converters.CursosLiberadosConverter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CursosLiberadosConverterTest {

    private CursosLiberadosConverter converter = new CursosLiberadosConverter();

    @Test
    void testConversaoNormal() {
        CursosLiberados obj = CursosLiberados.of(3);
        Integer dbValue = 3;

        assertEquals(dbValue, converter.convertToDatabaseColumn(obj));
        assertEquals(obj, converter.convertToEntityAttribute(dbValue));
    }

    @Test
    void testCaminhosNulos() {
        assertNull(converter.convertToDatabaseColumn(null));
        assertNull(converter.convertToEntityAttribute(null));
    }
}