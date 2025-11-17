package aluno_ac2.ac2_ca.controller.test;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;

import aluno_ac2.ac2_ca.controller.AlunoController;
import aluno_ac2.ac2_ca.dto.AlunoCreateDTO;
import aluno_ac2.ac2_ca.dto.AlunoResponseDTO;
import aluno_ac2.ac2_ca.dto.UpdateMediaDTO;
import aluno_ac2.ac2_ca.service.AlunoService;


@WebMvcTest(AlunoController.class) // Testa SÓ o AlunoController
class AlunoControllerTest {

    @Autowired
    private MockMvc mockMvc; // Simula requisições HTTP

    @MockBean // Cria um mock do serviço (o controller não fala com o serviço real)
    private AlunoService alunoService;

    @Autowired
    private ObjectMapper objectMapper; // Converte objetos Java para JSON
    
    @Test
    void testBuscarAlunoPorId() throws Exception {
        // 1. Cenário
        AlunoResponseDTO dto = new AlunoResponseDTO(
            1L, "Carlos", "carlos@email.com", "Premium", 9.0, 15, 3
        );
        
        // 2. Treinamento do Mock
        when(alunoService.buscarPorId(1L)).thenReturn(dto);

        // 3. Ação e Verificação
        mockMvc.perform(get("/alunos/1")) // Simula GET /alunos/1
                .andExpect(status().isOk()) // Espera HTTP 200
                .andExpect(jsonPath("$.id", is(1))) // Verifica o JSON
                .andExpect(jsonPath("$.nome", is("Carlos")))
                .andExpect(jsonPath("$.plano", is("Premium")));
    }
    
    @Test
    void testListar() throws Exception {
        // 1. Cenário
        AlunoResponseDTO dto1 = new AlunoResponseDTO(1L, "Ana", "a@e.com", "Básico", 0, 0, 0);
        AlunoResponseDTO dto2 = new AlunoResponseDTO(2L, "Bia", "b@e.com", "Premium", 0, 0, 0);
        
        // 2. Treinamento
        when(alunoService.listarTodos()).thenReturn(List.of(dto1, dto2));

        // 3. Ação e Verificação
        mockMvc.perform(get("/alunos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2))) // Espera uma lista de 2
                .andExpect(jsonPath("$[0].nome", is("Ana")))
                .andExpect(jsonPath("$[1].nome", is("Bia")));
    }

    @Test
    void testCriar() throws Exception {
        // 1. Cenário
        AlunoCreateDTO createDTO = new AlunoCreateDTO("Carlos", "c@e.com", "Básico");
        AlunoResponseDTO responseDTO = new AlunoResponseDTO(1L, "Carlos", "c@e.com", "Básico", 0, 0, 0);

        // 2. Treinamento
        when(alunoService.criarAluno(any(AlunoCreateDTO.class))).thenReturn(responseDTO);

        // 3. Ação e Verificação
        mockMvc.perform(post("/alunos") // Simula um POST
                .contentType(MediaType.APPLICATION_JSON) // Diz que estamos enviando JSON
                .content(objectMapper.writeValueAsString(createDTO))) // Converte o DTO para JSON
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.nome", is("Carlos")));
    }
    
    @Test
    void testAtualizarMediaEndpoint() throws Exception {
        // 1. Cenário
        UpdateMediaDTO requestDTO = new UpdateMediaDTO(9.0);
        // O que esperamos que o serviço retorne
        AlunoResponseDTO responseDTO = new AlunoResponseDTO(1L, "Carlos", "c@e.com", "Básico", 9.0, 0, 0);

        // 2. Treinamento
        when(alunoService.atualizarMedia(eq(1L), any(UpdateMediaDTO.class)))
            .thenReturn(responseDTO);

        // 3. Ação e Verificação
        mockMvc.perform(put("/alunos/1/media") // Simula um PUT
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requestDTO))) // Envia a nova média
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.nome", is("Carlos")))
                .andExpect(jsonPath("$.mediaFinal", is(9.0))); // Verifica se a média foi atualizada
    }

    @Test
    void testLiberarCursosEndpoint() throws Exception {
        // 1. Cenário
        // O que esperamos que o serviço retorne
        AlunoResponseDTO responseDTO = new AlunoResponseDTO(1L, "Daniel", "d@e.com", "Básico", 8.0, 0, 3);

        // 2. Treinamento
        when(alunoService.liberarCursos(1L)).thenReturn(responseDTO);

        // 3. Ação e Verificação
        mockMvc.perform(post("/alunos/1/liberar-cursos")) // Simula um POST
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.nome", is("Daniel")))
                .andExpect(jsonPath("$.cursosLiberados", is(3))); // Verifica se os cursos foram liberados
    }
    
    @Test
    void testVerificarPlanoEndpoint() throws Exception {
        // 1. Cenário
        // O que esperamos que o serviço retorne (um aluno que acabou de ser atualizado)
        AlunoResponseDTO responseDTO = new AlunoResponseDTO(1L, "Ana", "ana@email.com", "Premium", 9.0, 12, 0);

        // 2. Treinamento
        when(alunoService.verificarPlano(1L)).thenReturn(responseDTO);

        // 3. Ação e Verificação
        mockMvc.perform(post("/alunos/1/verificar-plano")) // Simula o POST
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.nome", is("Ana")))
                .andExpect(jsonPath("$.plano", is("Premium"))); // Verifica se o plano foi atualizado
    }
}