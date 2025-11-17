package aluno_ac2.ac2_ca.entity.converters.test;

import aluno_ac2.ac2_ca.domain.CursosConcluidos;
import aluno_ac2.ac2_ca.entity.converters.CursosConcluidosConverter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CursosConcluidosConverterTest {

    private CursosConcluidosConverter converter = new CursosConcluidosConverter();

    @Test
    void testConversaoNormal() {
        CursosConcluidos obj = CursosConcluidos.of(15);
        Integer dbValue = 15;

        assertEquals(dbValue, converter.convertToDatabaseColumn(obj));
        assertEquals(obj, converter.convertToEntityAttribute(dbValue));
    }

    @Test
    void testCaminhosNulos() {
        assertNull(converter.convertToDatabaseColumn(null));
        assertNull(converter.convertToEntityAttribute(null));
    }
}