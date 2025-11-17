package aluno_ac2.ac2_ca.controller;

import aluno_ac2.ac2_ca.dto.AlunoCreateDTO;
import aluno_ac2.ac2_ca.dto.AlunoResponseDTO;
import aluno_ac2.ac2_ca.dto.UpdateMediaDTO;
import aluno_ac2.ac2_ca.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public AlunoResponseDTO criar(@RequestBody AlunoCreateDTO dto) {
        return alunoService.criarAluno(dto);
    }

    @GetMapping("/{id}")
    public AlunoResponseDTO buscar(@PathVariable Long id) {
        return alunoService.buscarPorId(id);
    }

    @GetMapping
    public List<AlunoResponseDTO> listar() {
        return alunoService.listarTodos();
    }

    @PutMapping("/{id}/media")
    public AlunoResponseDTO atualizarMedia(@PathVariable Long id, @RequestBody UpdateMediaDTO dto) {
        return alunoService.atualizarMedia(id, dto);
    }

    @PostMapping("/{id}/liberar-cursos")
    public AlunoResponseDTO liberarCursos(@PathVariable Long id) {
        return alunoService.liberarCursos(id);
    }

    @PostMapping("/{id}/verificar-plano")
    public AlunoResponseDTO verificarPlano(@PathVariable Long id) {
        return alunoService.verificarPlano(id);
    }
}