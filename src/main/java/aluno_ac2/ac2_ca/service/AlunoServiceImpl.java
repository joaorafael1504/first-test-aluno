package aluno_ac2.ac2_ca.service;

import aluno_ac2.ac2_ca.dto.*;
import aluno_ac2.ac2_ca.entity.Aluno;
import aluno_ac2.ac2_ca.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlunoServiceImpl implements AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    private Aluno getAluno(Long id) {
        return alunoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Aluno não encontrado")); // Crie uma exceção melhor
    }

    @Override
    @Transactional
    public AlunoResponseDTO criarAluno(AlunoCreateDTO dto) {
        Aluno aluno = new Aluno(dto.nome(), dto.email(), dto.plano());
        Aluno alunoSalvo = alunoRepository.save(aluno);
        return AlunoResponseDTO.fromEntity(alunoSalvo);
    }

    @Override
    @Transactional(readOnly = true)
    public AlunoResponseDTO buscarPorId(Long id) {
        return AlunoResponseDTO.fromEntity(getAluno(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<AlunoResponseDTO> listarTodos() {
        return alunoRepository.findAll().stream()
                .map(AlunoResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public AlunoResponseDTO atualizarMedia(Long id, UpdateMediaDTO dto) {
        Aluno aluno = getAluno(id);
        aluno.setMediaFinal(dto.media()); // Lógica de domínio
        return AlunoResponseDTO.fromEntity(alunoRepository.save(aluno));
    }

    @Override
    @Transactional
    public AlunoResponseDTO verificarPlano(Long id) {
        Aluno aluno = getAluno(id);
        aluno.verificarPlano(); // Lógica de domínio
        return AlunoResponseDTO.fromEntity(alunoRepository.save(aluno));
    }

    @Override
    @Transactional
    public AlunoResponseDTO liberarCursos(Long id) {
        Aluno aluno = getAluno(id);
        aluno.liberarCursos(); // Lógica de domínio
        return AlunoResponseDTO.fromEntity(alunoRepository.save(aluno));
    }
}