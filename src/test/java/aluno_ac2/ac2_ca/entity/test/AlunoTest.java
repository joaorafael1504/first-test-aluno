package aluno_ac2.ac2_ca.entity.test;

import aluno_ac2.ac2_ca.entity.Aluno;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AlunoTest {

    @Test
    void testVerificarPlanoComUpgrade() {
        Aluno aluno = new Aluno("Ana", "ana@email.com", "Básico");
        aluno.setMediaFinal(9.0);
        aluno.setCursosConcluidos(15);
        
        String novoPlano = aluno.verificarPlano();

        assertEquals("Premium", novoPlano);
        assertEquals("Premium", aluno.getPlano().asLabel());
    }

    @Test
    void testVerificarPlanoSemUpgradePorMedia() {
        Aluno aluno = new Aluno("Bia", "bia@email.com", "Básico");
        aluno.setMediaFinal(6.0); 
        aluno.setCursosConcluidos(15);
        
        String novoPlano = aluno.verificarPlano();

        assertEquals("Básico", novoPlano);
    }

    @Test
    void testLiberarCursosComSucesso() {
        Aluno aluno = new Aluno("Carlos", "carlos@email.com", "Básico");
        aluno.setMediaFinal(7.0);
        
        int cursosLiberados = aluno.liberarCursos();

        assertEquals(3, cursosLiberados);
        assertEquals(3, aluno.getCursosLiberados().value());
    }

    @Test
    void testLiberarCursosComMediaBaixa() {
        Aluno aluno = new Aluno("Daniel", "daniel@email.com", "Básico");
        aluno.setMediaFinal(6.9); 
        
        int cursosLiberados = aluno.liberarCursos();

        assertEquals(0, cursosLiberados);
        assertEquals(0, aluno.getCursosLiberados().value());
    }

    @Test
    void testLiberarCursosDuasVezes() {
        Aluno aluno = new Aluno("Elisa", "elisa@email.com", "Básico");
        aluno.setMediaFinal(8.0);
        
        aluno.liberarCursos();
        int cursosLiberados = aluno.liberarCursos();

        assertEquals(3, cursosLiberados);
    }
    
    @Test
    void testVerificarPlanoSemUpgradePorFaltaDeCursos() {
        Aluno aluno = new Aluno("Bia", "bia@email.com", "Básico");
        aluno.setMediaFinal(9.0);
        aluno.setCursosConcluidos(11);
        
        String novoPlano = aluno.verificarPlano();

        assertEquals("Básico", novoPlano);
        assertEquals("Básico", aluno.getPlano().asLabel());
    }
    
    @Test
    void testVerificarPlanoSemUpgradePorPlanoNaoBasico() {
        Aluno aluno = new Aluno("Fernando", "fernando@email.com", "Premium");
        aluno.setMediaFinal(8.0);
        aluno.setCursosConcluidos(15);
        
        String novoPlano = aluno.verificarPlano();

        assertEquals("Premium", novoPlano);
        assertEquals("Premium", aluno.getPlano().asLabel());
    }
}