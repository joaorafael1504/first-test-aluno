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


@WebMvcTest(AlunoController.class)
class AlunoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AlunoService alunoService;

    @Autowired
    private ObjectMapper objectMapper;
    
    @Test
    void testBuscarAlunoPorId() throws Exception {
        AlunoResponseDTO dto = new AlunoResponseDTO(
            1L, "Carlos", "carlos@email.com", "Premium", 9.0, 15, 3
        );
        
        when(alunoService.buscarPorId(1L)).thenReturn(dto);

        mockMvc.perform(get("/alunos/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.nome", is("Carlos")))
                .andExpect(jsonPath("$.plano", is("Premium")));
    }
    
    @Test
    void testListar() throws Exception {
        AlunoResponseDTO dto1 = new AlunoResponseDTO(1L, "Ana", "a@e.com", "Básico", 0, 0, 0);
        AlunoResponseDTO dto2 = new AlunoResponseDTO(2L, "Bia", "b@e.com", "Premium", 0, 0, 0);
        
        when(alunoService.listarTodos()).thenReturn(List.of(dto1, dto2));

        mockMvc.perform(get("/alunos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].nome", is("Ana")))
                .andExpect(jsonPath("$[1].nome", is("Bia")));
    }

    @Test
    void testCriar() throws Exception {
        AlunoCreateDTO createDTO = new AlunoCreateDTO("Carlos", "c@e.com", "Básico");
        AlunoResponseDTO responseDTO = new AlunoResponseDTO(1L, "Carlos", "c@e.com", "Básico", 0, 0, 0);

        when(alunoService.criarAluno(any(AlunoCreateDTO.class))).thenReturn(responseDTO);

        mockMvc.perform(post("/alunos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(createDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.nome", is("Carlos")));
    }
    
    @Test
    void testAtualizarMediaEndpoint() throws Exception {
        UpdateMediaDTO requestDTO = new UpdateMediaDTO(9.0);
        AlunoResponseDTO responseDTO = new AlunoResponseDTO(1L, "Carlos", "c@e.com", "Básico", 9.0, 0, 0);

        when(alunoService.atualizarMedia(eq(1L), any(UpdateMediaDTO.class)))
            .thenReturn(responseDTO);

        mockMvc.perform(put("/alunos/1/media")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requestDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.nome", is("Carlos")))
                .andExpect(jsonPath("$.mediaFinal", is(9.0)));
    }

    @Test
    void testLiberarCursosEndpoint() throws Exception {
        AlunoResponseDTO responseDTO = new AlunoResponseDTO(1L, "Daniel", "d@e.com", "Básico", 8.0, 0, 3);

        when(alunoService.liberarCursos(1L)).thenReturn(responseDTO);

        mockMvc.perform(post("/alunos/1/liberar-cursos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.nome", is("Daniel")))
                .andExpect(jsonPath("$.cursosLiberados", is(3)));
    }
    
    @Test
    void testVerificarPlanoEndpoint() throws Exception {
        AlunoResponseDTO responseDTO = new AlunoResponseDTO(1L, "Ana", "ana@email.com", "Premium", 9.0, 12, 0);

        when(alunoService.verificarPlano(1L)).thenReturn(responseDTO);

        mockMvc.perform(post("/alunos/1/verificar-plano"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.nome", is("Ana")))
                .andExpect(jsonPath("$.plano", is("Premium")));
    }
}