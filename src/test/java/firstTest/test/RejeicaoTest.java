package firstTest.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import firstTest.modelo.Aluno;

public class RejeicaoTest {

    @Test
    void naoLiberacaoDeCursosPorMediaBaixa() {
        Aluno aluno = new Aluno("Maria", "Básico");
        aluno.setMediaFinal(6.5);

        int cursosLiberados = aluno.cursosLiberados();

        assertEquals(0, cursosLiberados,
            "O aluno não deveria receber cursos com média menor que 7");
    }
}
