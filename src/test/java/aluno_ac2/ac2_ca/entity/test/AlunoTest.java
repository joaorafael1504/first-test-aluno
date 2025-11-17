package aluno_ac2.ac2_ca.entity.test;

import aluno_ac2.ac2_ca.entity.Aluno;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Este é um teste unitário puro, não precisa de anotações do Spring
class AlunoTest {

    @Test
    void testVerificarPlanoComUpgrade() {
        // 1. Cenário (Given)
        // Cria um aluno com as condições para o upgrade
        Aluno aluno = new Aluno("Ana", "ana@email.com", "Básico");
        aluno.setMediaFinal(9.0);
        aluno.setCursosConcluidos(15);
        
        // 2. Ação (When)
        String novoPlano = aluno.verificarPlano();

        // 3. Verificação (Then)
        assertEquals("Premium", novoPlano);
        // Garante que o estado interno do aluno também mudou
        assertEquals("Premium", aluno.getPlano().asLabel());
    }

    @Test
    void testVerificarPlanoSemUpgradePorMedia() {
        // 1. Cenário (Given)
        // Média baixa
        Aluno aluno = new Aluno("Bia", "bia@email.com", "Básico");
        aluno.setMediaFinal(6.0); 
        aluno.setCursosConcluidos(15);
        
        // 2. Ação (When)
        String novoPlano = aluno.verificarPlano();

        // 3. Verificação (Then)
        assertEquals("Básico", novoPlano);
    }

    @Test
    void testLiberarCursosComSucesso() {
        // 1. Cenário (Given)
        // Média suficiente e cursos liberados = 0
        Aluno aluno = new Aluno("Carlos", "carlos@email.com", "Básico");
        aluno.setMediaFinal(7.0);
        
        // 2. Ação (When)
        int cursosLiberados = aluno.liberarCursos();

        // 3. Verificação (Then)
        assertEquals(3, cursosLiberados);
        assertEquals(3, aluno.getCursosLiberados().value());
    }

    @Test
    void testLiberarCursosComMediaBaixa() {
        // 1. Cenário (Given)
        // Média insuficiente
        Aluno aluno = new Aluno("Daniel", "daniel@email.com", "Básico");
        aluno.setMediaFinal(6.9); 
        
        // 2. Ação (When)
        int cursosLiberados = aluno.liberarCursos();

        // 3. Verificação (Then)
        assertEquals(0, cursosLiberados);
        assertEquals(0, aluno.getCursosLiberados().value());
    }

    @Test
    void testLiberarCursosDuasVezes() {
        // 1. Cenário (Given)
        Aluno aluno = new Aluno("Elisa", "elisa@email.com", "Básico");
        aluno.setMediaFinal(8.0);
        
        // 2. Ação (When)
        aluno.liberarCursos(); // Primeira chamada, deve liberar 3
        int cursosLiberados = aluno.liberarCursos(); // Segunda chamada, não deve fazer nada

        // 3. Verificação (Then)
        // A regra "cursosLiberados.isZero()" deve ter impedido a segunda chamada
        assertEquals(3, cursosLiberados);
    }
    
    @Test
    void testVerificarPlanoSemUpgradePorFaltaDeCursos() {
        // 1. Cenário (Given)
        // Média boa, mas cursos insuficientes
        Aluno aluno = new Aluno("Bia", "bia@email.com", "Básico");
        aluno.setMediaFinal(9.0);
        aluno.setCursosConcluidos(11); // Faltou 1!
        
        // 2. Ação (When)
        String novoPlano = aluno.verificarPlano();

        // 3. Verificação (Then)
        // Testa o "else" da verificação
        assertEquals("Básico", novoPlano);
        assertEquals("Básico", aluno.getPlano().asLabel());
    }
}