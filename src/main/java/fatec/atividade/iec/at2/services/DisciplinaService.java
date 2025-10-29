package fatec.atividade.iec.at2.services;

import fatec.atividade.iec.at2.records.Disciplina;
import fatec.atividade.iec.at2.repositories.DisciplinasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinaService {

    private final DisciplinasRepository disciplinasRepository;

    public DisciplinaService(DisciplinasRepository disciplinasRepository) {
        this.disciplinasRepository = disciplinasRepository;
    }

    public List<Disciplina> findAll() {
        return  disciplinasRepository.findAll();
    }

    public List<Disciplina> findAll(String id) {
        return  disciplinasRepository.findById(id);
    }
}
