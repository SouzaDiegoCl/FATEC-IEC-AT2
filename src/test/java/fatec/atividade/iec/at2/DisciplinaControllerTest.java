package fatec.atividade.iec.at2;

import fatec.atividade.iec.at2.controllers.DisciplinaController;
import fatec.atividade.iec.at2.records.Disciplina;
import fatec.atividade.iec.at2.services.DisciplinaService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DisciplinaControllerTest {

    private final DisciplinaService service = Mockito.mock(DisciplinaService.class);
    private final DisciplinaController controller = new DisciplinaController(service);

    @Test
    void listarDisciplinas_retornaOk() {
        when(service.findAll()).thenReturn(List.of(new Disciplina("IEC", "Integração")));
        ResponseEntity<List<Disciplina>> response = controller.listarDisciplinas();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
    }

    @Test
    void adicionarDisciplina_retornaCreated() {
        when(service.save("PDM", "Programação")).thenReturn(true);
        ResponseEntity<?> response = controller.adicionarDisciplina(new Disciplina("PDM", "Programação"));
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }
}
