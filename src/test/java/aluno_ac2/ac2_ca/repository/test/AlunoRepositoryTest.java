package aluno_ac2.ac2_ca.repository.test;

import aluno_ac2.ac2_ca.entity.Aluno;
import aluno_ac2.ac2_ca.repository.AlunoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AlunoRepositoryTest {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    void testSalvarEBuscarAlunoComConversor() {
        Aluno aluno = new Aluno("João", "joao@email.com", "Básico");
        aluno.setMediaFinal(8.5);

        Aluno alunoSalvo = testEntityManager.persistAndFlush(aluno);
        Aluno alunoBuscado = alunoRepository.findById(alunoSalvo.getId()).orElse(null);

        assertNotNull(alunoBuscado);
        assertEquals("João", alunoBuscado.getNome());
        assertEquals(8.5, alunoBuscado.getMediaFinal().value());
        assertEquals("Básico", alunoBuscado.getPlano().asLabel());
    }
}