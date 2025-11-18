package aluno_ac2.ac2_ca.service.test;

import aluno_ac2.ac2_ca.dto.AlunoCreateDTO;
import aluno_ac2.ac2_ca.dto.AlunoResponseDTO;
import aluno_ac2.ac2_ca.dto.UpdateMediaDTO;
import aluno_ac2.ac2_ca.entity.Aluno;
import aluno_ac2.ac2_ca.repository.AlunoRepository;
import aluno_ac2.ac2_ca.service.AlunoServiceImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AlunoServiceImplTest {

    @Mock
    private AlunoRepository alunoRepository;

    @InjectMocks
    private AlunoServiceImpl alunoService;

    @Test
    void testVerificarPlanoComUpgrade() {
        Aluno alunoMock = new Aluno("Ana", "ana@email.com", "Básico");
        alunoMock.setMediaFinal(9.0);
        alunoMock.setCursosConcluidos(15);

        when(alunoRepository.findById(1L)).thenReturn(Optional.of(alunoMock));
        when(alunoRepository.save(any(Aluno.class))).thenReturn(alunoMock);

        alunoService.verificarPlano(1L);

        assertEquals("Premium", alunoMock.getPlano().asLabel());
        verify(alunoRepository, times(1)).save(alunoMock);
    }

    @Test
    void testCriarAluno() {
        AlunoCreateDTO dto = new AlunoCreateDTO("Novo Aluno", "novo@email.com", "Básico");
        Aluno aluno = new Aluno("Novo Aluno", "novo@email.com", "Básico");

        when(alunoRepository.save(any(Aluno.class))).thenReturn(aluno);

        AlunoResponseDTO response = alunoService.criarAluno(dto);

        assertNotNull(response);
        assertEquals("Novo Aluno", response.nome());
        verify(alunoRepository, times(1)).save(any(Aluno.class));
    }

    @Test
    void testBuscarPorId() {
        Aluno aluno = new Aluno("Aluno Teste", "teste@email.com", "Premium");

        when(alunoRepository.findById(1L)).thenReturn(Optional.of(aluno));

        AlunoResponseDTO response = alunoService.buscarPorId(1L);

        assertNotNull(response);
        assertEquals("Aluno Teste", response.nome());
        assertEquals("Premium", response.plano());
    }

    @Test
    void testBuscarPorIdNaoEncontrado() {
        when(alunoRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> {
            alunoService.buscarPorId(99L);
        });
    }

    @Test
    void testListarTodos() {
        Aluno aluno1 = new Aluno("Ana", "ana@email.com", "Básico");
        Aluno aluno2 = new Aluno("Bia", "bia@email.com", "Premium");

        when(alunoRepository.findAll()).thenReturn(List.of(aluno1, aluno2));

        List<AlunoResponseDTO> lista = alunoService.listarTodos();

        assertNotNull(lista);
        assertEquals(2, lista.size());
        assertEquals("Ana", lista.get(0).nome());
        assertEquals("Bia", lista.get(1).nome());
    }

    @Test
    void testAtualizarMedia() {
        Aluno alunoMock = new Aluno("Ana", "ana@email.com", "Básico");
        UpdateMediaDTO dto = new UpdateMediaDTO(9.5);

        when(alunoRepository.findById(1L)).thenReturn(Optional.of(alunoMock));
        when(alunoRepository.save(any(Aluno.class))).thenReturn(alunoMock);

        alunoService.atualizarMedia(1L, dto);

        assertEquals(9.5, alunoMock.getMediaFinal().value());
        verify(alunoRepository, times(1)).save(alunoMock);
    }

    @Test
    void testLiberarCursosComSucesso() {
        Aluno alunoMock = new Aluno("Bia", "bia@email.com", "Básico");
        alunoMock.setMediaFinal(8.0);

        when(alunoRepository.findById(1L)).thenReturn(Optional.of(alunoMock));
        when(alunoRepository.save(any(Aluno.class))).thenReturn(alunoMock);

        alunoService.liberarCursos(1L);

        assertEquals(3, alunoMock.getCursosLiberados().value());
        verify(alunoRepository, times(1)).save(alunoMock);
    }
}