package aluno_ac2.ac2_ca.dto;

// Isso cria o construtor (String, String, String) automaticamente
public record AlunoCreateDTO(
    String nome,
    String email,
    String plano
) {}