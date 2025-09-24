package firstTest.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import firstTest.modelo.Aluno;

public class PromoverTest {

    @Test
    void promoverParaPlanoPremium() {
        Aluno aluno = new Aluno("Carlos", "Básico");
        aluno.setCursosConcluidos(13);
        aluno.setMediaFinal(7.5);

        String plano = aluno.verificarPlano();

        assertEquals("Premium", plano,
            "O aluno deveria migrar para Premium após 12 cursos concluídos com média acima de 7");
    }
}
