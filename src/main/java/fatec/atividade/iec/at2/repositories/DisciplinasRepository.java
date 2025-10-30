package fatec.atividade.iec.at2.repositories;

import fatec.atividade.iec.at2.records.Disciplina;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class DisciplinasRepository {
    HashMap<String, String> disciplinas;

    public DisciplinasRepository() {
        disciplinas = new HashMap<>();
        disciplinas.put("IEC", new String("Integração e Entrega Continua"));
        disciplinas.put("PDM", new String("Programação para Dispositivos Móveis"));
    }

    public List<Disciplina> findAll() {
        return disciplinas.entrySet().stream().map(entry -> new Disciplina(entry.getKey(), entry.getValue())).toList();
    }

    public List<Disciplina> findById(String id) {
        return disciplinas.entrySet().stream().filter(d -> Objects.equals(d.getKey(), id)).map(entry -> new Disciplina(entry.getKey(), entry.getValue())).toList();
    }

    public boolean save(String id, String nome) {
        try{
            disciplinas.put(id, nome);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
