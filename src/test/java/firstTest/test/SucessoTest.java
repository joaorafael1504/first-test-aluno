package firstTest.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import firstTest.modelo.Aluno;

public class SucessoTest {

    @Test
    void liberacaoDeCursosPorMediaAlta() {
        Aluno aluno = new Aluno("João", "Básico");
        aluno.setMediaFinal(8.0);

        int cursosLiberados = aluno.liberarCursos();

        assertEquals(3, cursosLiberados,
            "O aluno deveria ter 3 cursos liberados ao concluir com média 8");
    }
}
