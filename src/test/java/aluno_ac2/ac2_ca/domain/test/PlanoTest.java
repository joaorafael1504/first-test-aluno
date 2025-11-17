package aluno_ac2.ac2_ca.domain.test;

import aluno_ac2.ac2_ca.domain.Plano;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlanoTest {

    @Test
    void testFromLabelComValoresValidos() {
        // Testa as strings exatas
        assertEquals(Plano.PREMIUM, Plano.fromLabel("Premium"));
        assertEquals(Plano.BASICO, Plano.fromLabel("Básico"));
    }

    @Test
    void testFromLabelComVariacoes() {
        // Testa variações (maiúsculas/minúsculas, sem acento)
        assertEquals(Plano.PREMIUM, Plano.fromLabel("premium"));
        assertEquals(Plano.BASICO, Plano.fromLabel("basico"));
    }

    @Test
    void testFromLabelComFallback() {
        // Testa fallback para BASICO
        assertEquals(Plano.BASICO, Plano.fromLabel("QualquerCoisa"));
        assertEquals(Plano.BASICO, Plano.fromLabel(null));
    }

    @Test
    void testAsLabel() {
        // Testa a conversão de volta para String
        assertEquals("Premium", Plano.PREMIUM.asLabel());
        assertEquals("Básico", Plano.BASICO.asLabel());
    }
    
    @Test
    void testIsPremium() {
        // Testa a linha vermelha do 'isPremium()'
        assertTrue(Plano.PREMIUM.isPremium());
        assertFalse(Plano.BASICO.isPremium());
    }

    @Test
    void testFromLabelComStringsDiferentes() {
        // Testa os caminhos amarelos (branches) do 'fromLabel'
        assertEquals(Plano.BASICO, Plano.fromLabel("qualquercoisa"));
        assertEquals(Plano.PREMIUM, Plano.fromLabel("premium"));
    }
}