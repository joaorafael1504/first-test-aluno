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

@ExtendWith(MockitoExtension.class) // Habilita o Mockito
class AlunoServiceImplTest {

    @Mock // Cria um repositório falso
    private AlunoRepository alunoRepository;

    @InjectMocks // Cria o serviço e injeta o repositório falso nele
    private AlunoServiceImpl alunoService;

    @Test
    void testVerificarPlanoComUpgrade() {
        // 1. Cenário
        Aluno alunoMock = new Aluno("Ana", "ana@email.com", "Básico");
        alunoMock.setMediaFinal(9.0);
        alunoMock.setCursosConcluidos(15);
        
        // 2. Treinamento do Mock
        when(alunoRepository.findById(1L)).thenReturn(Optional.of(alunoMock));
        when(alunoRepository.save(any(Aluno.class))).thenReturn(alunoMock);

        // 3. Ação
        alunoService.verificarPlano(1L);

        // 4. Verificação
        // O plano foi alterado no objeto mock?
        assertEquals("Premium", alunoMock.getPlano().asLabel());
        // O método save foi chamado?
        verify(alunoRepository, times(1)).save(alunoMock);
    }

    @Test
    void testCriarAluno() {
        // 1. Cenário
        AlunoCreateDTO dto = new AlunoCreateDTO("Novo Aluno", "novo@email.com", "Básico");
        Aluno aluno = new Aluno("Novo Aluno", "novo@email.com", "Básico");
        
        // 2. Treinamento
        when(alunoRepository.save(any(Aluno.class))).thenReturn(aluno);

        // 3. Ação
        AlunoResponseDTO response = alunoService.criarAluno(dto);

        // 4. Verificação
        assertNotNull(response);
        assertEquals("Novo Aluno", response.nome());
        verify(alunoRepository, times(1)).save(any(Aluno.class));
    }

    @Test
    void testBuscarPorId() {
        // 1. Cenário
        Aluno aluno = new Aluno("Aluno Teste", "teste@email.com", "Premium");
        
        // 2. Treinamento
        when(alunoRepository.findById(1L)).thenReturn(Optional.of(aluno));

        // 3. Ação
        AlunoResponseDTO response = alunoService.buscarPorId(1L);

        // 4. Verificação
        assertNotNull(response);
        assertEquals("Aluno Teste", response.nome());
        assertEquals("Premium", response.plano());
    }

    @Test
    void testBuscarPorIdNaoEncontrado() {
        // 1. Cenário
        // 2. Treinamento
        when(alunoRepository.findById(99L)).thenReturn(Optional.empty());

        // 3. Ação e Verificação
        // Testa se o .orElseThrow() do serviço funciona
        assertThrows(RuntimeException.class, () -> {
            alunoService.buscarPorId(99L);
        });
    }

    @Test
    void testListarTodos() {
        // 1. Cenário
        Aluno aluno1 = new Aluno("Ana", "ana@email.com", "Básico");
        Aluno aluno2 = new Aluno("Bia", "bia@email.com", "Premium");
        
        // 2. Treinamento
        when(alunoRepository.findAll()).thenReturn(List.of(aluno1, aluno2));

        // 3. Ação
        List<AlunoResponseDTO> lista = alunoService.listarTodos();

        // 4. Verificação
        assertNotNull(lista);
        assertEquals(2, lista.size());
        assertEquals("Ana", lista.get(0).nome());
        assertEquals("Bia", lista.get(1).nome());
    }
    
    @Test
    void testAtualizarMedia() {
        // 1. Cenário
        Aluno alunoMock = new Aluno("Ana", "ana@email.com", "Básico");
        // DTO com a nova média
        UpdateMediaDTO dto = new UpdateMediaDTO(9.5);
        
        // 2. Treinamento
        when(alunoRepository.findById(1L)).thenReturn(Optional.of(alunoMock));
        when(alunoRepository.save(any(Aluno.class))).thenReturn(alunoMock);

        // 3. Ação
        alunoService.atualizarMedia(1L, dto);

        // 4. Verificação
        // A lógica de negócio foi aplicada no objeto mock?
        assertEquals(9.5, alunoMock.getMediaFinal().value());
        // O repositório foi chamado para salvar?
        verify(alunoRepository, times(1)).save(alunoMock);
    }

    @Test
    void testLiberarCursosComSucesso() {
        // 1. Cenário
        Aluno alunoMock = new Aluno("Bia", "bia@email.com", "Básico");
        alunoMock.setMediaFinal(8.0); // Média suficiente
        
        // 2. Treinamento
        when(alunoRepository.findById(1L)).thenReturn(Optional.of(alunoMock));
        when(alunoRepository.save(any(Aluno.class))).thenReturn(alunoMock);

        // 3. Ação
        alunoService.liberarCursos(1L);

        // 4. Verificação
        // A lógica de negócio foi aplicada?
        assertEquals(3, alunoMock.getCursosLiberados().value());
        // O repositório foi chamado para salvar?
        verify(alunoRepository, times(1)).save(alunoMock);
    }
}