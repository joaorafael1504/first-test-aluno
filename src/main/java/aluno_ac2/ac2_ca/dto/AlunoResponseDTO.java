package aluno_ac2.ac2_ca.dto;

import aluno_ac2.ac2_ca.entity.Aluno;

public record AlunoResponseDTO(
    Long id,
    String nome,
    String email,
    String plano,
    double mediaFinal,
    int cursosConcluidos,
    int cursosLiberados
) {
    public static AlunoResponseDTO fromEntity(Aluno aluno) {
        return new AlunoResponseDTO(
            aluno.getId(),
            aluno.getNome(),
            aluno.getEmail(),
            aluno.getPlano().asLabel(),
            aluno.getMediaFinal().value(),
            aluno.getCursosConcluidos().value(),
            aluno.getCursosLiberados().value()
        );
    }
}