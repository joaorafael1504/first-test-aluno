package firstTest.test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import firstTest.modelo.Aluno;

public class DuplicadoTest {
	
	@Test
	void naoConcederCursosDuplicados() {
        Aluno aluno = new Aluno("Ana", "Básico");
        aluno.setMediaFinal(8.5);
        aluno.liberarCursos();

        int cursosLiberados = aluno.liberarCursos();

        assertEquals(3, cursosLiberados, 
            "O aluno não deve ganhar mais cursos duplicados ao processar a mesma conclusão");
    }
}
