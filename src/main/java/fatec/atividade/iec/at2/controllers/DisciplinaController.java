package fatec.atividade.iec.at2.controllers;

import fatec.atividade.iec.at2.records.Disciplina;
import fatec.atividade.iec.at2.services.DisciplinaService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

    private final DisciplinaService disciplinaService;

    public DisciplinaController(DisciplinaService disciplinaService) {
        this.disciplinaService = disciplinaService;
    }

    @GetMapping
    public List<Disciplina> listarDisciplinas(){
        return disciplinaService.findAll();
    }

    @GetMapping("/{id}")
    public void buscarDisciplinaPeloId(@PathVariable("id") String id){
        return disciplinaService.findById(id);
    }

    @PostMapping
    public void adicionarDisciplina(@RequestBody Disciplina dto){
    }
}
