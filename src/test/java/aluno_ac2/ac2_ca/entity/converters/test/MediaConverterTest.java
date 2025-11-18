package aluno_ac2.ac2_ca.entity.converters.test;

import aluno_ac2.ac2_ca.domain.Media;
import aluno_ac2.ac2_ca.entity.converters.MediaConverter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MediaConverterTest {

    private MediaConverter converter = new MediaConverter();

    @Test
    void testConversaoNormal() {
        Media mediaObj = Media.of(7.5);
        Double dbValue = 7.5;

        assertEquals(dbValue, converter.convertToDatabaseColumn(mediaObj));
        assertEquals(mediaObj, converter.convertToEntityAttribute(dbValue));
    }

    @Test
    void testCaminhosNulos() {
        assertNull(converter.convertToDatabaseColumn(null));
        assertNull(converter.convertToEntityAttribute(null));
    }
}