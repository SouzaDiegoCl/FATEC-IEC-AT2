package fatec.atividade.iec.at2;

import fatec.atividade.iec.at2.records.Disciplina;
import fatec.atividade.iec.at2.repositories.DisciplinasRepository;
import fatec.atividade.iec.at2.services.DisciplinaService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DisciplinaServiceTest {

    private final DisciplinasRepository repository = Mockito.mock(DisciplinasRepository.class);
    private final DisciplinaService service = new DisciplinaService(repository);

    @Test
    void findAll_retornaListaDeDisciplinas() {
        when(repository.findAll()).thenReturn(List.of(new Disciplina("IEC", "Integração")));
        List<Disciplina> result = service.findAll();
        assertEquals(1, result.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    void save_quandoFalha_retornaFalse() {
        when(repository.save("XXX", "Teste")).thenReturn(false);
        boolean result = service.save("XXX", "Teste");
        assertFalse(result);
    }
}
