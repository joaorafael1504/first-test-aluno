package firstTest.modelo;

public class Aluno {
    private Plano plano;
    private Media mediaFinal;
    private CursosConcluidos cursosConcluidos;
    private CursosLiberados cursosLiberados;

    public Aluno(String nome, String plano) {
        this.plano = Plano.fromLabel(plano);
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

    public int cursosLiberados() {
        return this.cursosLiberados.value();
    }

    public String verificarPlano() {
        if (this.plano == Plano.BASICO && this.cursosConcluidos.isAtLeast(12) && this.mediaFinal.isAtLeast(7.0)) {
            this.plano = Plano.PREMIUM;
        }
        return this.plano.asLabel();
    }
}
