package aluno_ac2.ac2_ca.service;

import aluno_ac2.ac2_ca.dto.AlunoCreateDTO;
import aluno_ac2.ac2_ca.dto.AlunoResponseDTO;
import aluno_ac2.ac2_ca.dto.UpdateMediaDTO;
import java.util.List;

public interface AlunoService {
    AlunoResponseDTO criarAluno(AlunoCreateDTO dto);
    AlunoResponseDTO buscarPorId(Long id);
    List<AlunoResponseDTO> listarTodos();
    AlunoResponseDTO atualizarMedia(Long id, UpdateMediaDTO dto);
    AlunoResponseDTO verificarPlano(Long id);
    AlunoResponseDTO liberarCursos(Long id);
}