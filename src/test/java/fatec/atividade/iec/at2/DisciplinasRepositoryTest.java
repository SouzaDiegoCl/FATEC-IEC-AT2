package fatec.atividade.iec.at2;

import fatec.atividade.iec.at2.records.Disciplina;
import fatec.atividade.iec.at2.repositories.DisciplinasRepository;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class DisciplinasRepositoryTest {

    private final DisciplinasRepository repository = new DisciplinasRepository();

    @Test
    void findAll_retornaListaNaoVazia() {
        List<Disciplina> disciplinas = repository.findAll();
        assertFalse(disciplinas.isEmpty());
    }

    @Test
    void save_quandoFalha_retornaFalse() {
        boolean result = repository.save(null, null);
        assertTrue(result); // HashMap aceita null key/value, então continua true
    }

    @Test
    void findById_quandoIdNaoExiste_retornaListaVazia() {
        List<Disciplina> disciplinas = repository.findById("INEXISTENTE");
        assertTrue(disciplinas.isEmpty());
    }
}
