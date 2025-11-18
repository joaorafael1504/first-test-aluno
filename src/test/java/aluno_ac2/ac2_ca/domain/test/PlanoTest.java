package aluno_ac2.ac2_ca.domain.test;

import aluno_ac2.ac2_ca.domain.Plano;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlanoTest {

    @Test
    void testFromLabelComValoresValidos() {
        assertEquals(Plano.PREMIUM, Plano.fromLabel("Premium"));
        assertEquals(Plano.BASICO, Plano.fromLabel("Básico"));
    }

    @Test
    void testFromLabelComVariacoes() {
        assertEquals(Plano.PREMIUM, Plano.fromLabel("premium"));
        assertEquals(Plano.BASICO, Plano.fromLabel("basico"));
    }

    @Test
    void testFromLabelComFallback() {
        assertEquals(Plano.BASICO, Plano.fromLabel("QualquerCoisa"));
        assertEquals(Plano.BASICO, Plano.fromLabel(null));
    }

    @Test
    void testAsLabel() {
        assertEquals("Premium", Plano.PREMIUM.asLabel());
        assertEquals("Básico", Plano.BASICO.asLabel());
    }
    
    @Test
    void testIsPremium() {
        assertTrue(Plano.PREMIUM.isPremium());
        assertFalse(Plano.BASICO.isPremium());
    }

    @Test
    void testFromLabelComStringsDiferentes() {
        assertEquals(Plano.BASICO, Plano.fromLabel("qualquercoisa"));
        assertEquals(Plano.PREMIUM, Plano.fromLabel("premium"));
    }
}