package aluno_ac2.ac2_ca.entity.converters.test;

import aluno_ac2.ac2_ca.domain.Plano;
import aluno_ac2.ac2_ca.entity.converters.PlanoConverter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Teste unitário puro, sem anotações do Spring
class PlanoConverterTest {

    // Cria uma instância do conversor que queremos testar
    private PlanoConverter converter = new PlanoConverter();

    @Test
    void testConversaoNormal() {
        // 1. Testa o "caminho feliz" da Linha 13 (plano != null)
        assertEquals("Premium", converter.convertToDatabaseColumn(Plano.PREMIUM));
        
        // 2. Testa o "caminho feliz" da Linha 19 (dbData != null)
        assertEquals(Plano.BASICO, converter.convertToEntityAttribute("Básico"));
    }

    @Test
    void testCaminhosNulos() {
        // 1. Testa o "caminho nulo" da Linha 13 (plano == null)
        assertNull(converter.convertToDatabaseColumn(null));
        
        // 2. Testa o "caminho nulo" da Linha 19 (dbData == null)
        assertNull(converter.convertToEntityAttribute(null));
    }
}