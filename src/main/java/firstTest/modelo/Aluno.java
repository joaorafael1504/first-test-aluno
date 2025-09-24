package firstTest.modelo;

public class Aluno {
    private String plano;
    private double mediaFinal;
    private int cursosConcluidos;
    private int cursosLiberados;

    public Aluno(String nome, String plano) {
        this.plano = plano;
        this.mediaFinal = 0.0;
        this.cursosConcluidos = 0;
        this.cursosLiberados = 0;
    }

    public void setMediaFinal(double mediaFinal) {
        this.mediaFinal = mediaFinal;
    }

    public void setCursosConcluidos(int cursosConcluidos) {
        this.cursosConcluidos = cursosConcluidos;
    }

    public int liberarCursos() {
        if (mediaFinal >= 7 && cursosLiberados <= 0) {
            cursosLiberados = 3;
        }
        return cursosLiberados;
    }

    public int cursosLiberados() {
        return cursosLiberados;
    }

    public String verificarPlano() {
        if ("Básico".equals(plano) && cursosConcluidos >= 12 && mediaFinal >= 7) {
            plano = "Premium";
        }
        return plano;
    }
}
