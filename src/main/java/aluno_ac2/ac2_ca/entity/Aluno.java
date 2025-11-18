package aluno_ac2.ac2_ca.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import aluno_ac2.ac2_ca.domain.*;

@Entity
@Table(name = "alunos")
@Getter
@NoArgsConstructor
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;

    private Plano plano;
    private Media mediaFinal;
    private CursosConcluidos cursosConcluidos;
    private CursosLiberados cursosLiberados;
    
    
    public Aluno(String nome, String email, String planoLabel) {
        this.nome = nome;
        this.email = email;
        this.plano = Plano.fromLabel(planoLabel);
        this.mediaFinal = Media.of(0.0);
        this.cursosConcluidos = CursosConcluidos.of(0);
        this.cursosLiberados = CursosLiberados.of(0);
    }

    
    public void setMediaFinal(double mediaFinal) {
        this.mediaFinal = Media.of(mediaFinal);
    }
    public void setCursosConcluidos(int cursosConcluidos) {
        this.cursosConcluidos = CursosConcluidos.of(cursosConcluidos);
    }
    public int liberarCursos() {
        if (this.mediaFinal.isAtLeast(7.0) && this.cursosLiberados.isZero()) {
            this.cursosLiberados = CursosLiberados.of(3);
        }
        return this.cursosLiberados.value();
    }
    public String verificarPlano() {
        if (this.plano == Plano.BASICO && this.cursosConcluidos.isAtLeast(12) && this.mediaFinal.isAtLeast(7.0)) {
            this.plano = Plano.PREMIUM;
        }
        return this.plano.asLabel();
    }
}