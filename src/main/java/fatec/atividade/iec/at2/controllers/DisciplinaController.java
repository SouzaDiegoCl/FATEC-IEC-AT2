package fatec.atividade.iec.at2.controllers;

import fatec.atividade.iec.at2.records.Disciplina;
import fatec.atividade.iec.at2.services.DisciplinaService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Disciplina>> listarDisciplinas(){
        return ResponseEntity.ok(disciplinaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Disciplina>> buscarDisciplinaPeloId(@PathVariable("id") String id){
        return ResponseEntity.ok(disciplinaService.findById(id));
    }

    @PostMapping
    public ResponseEntity adicionarDisciplina(@RequestBody Disciplina disciplina){
        disciplinaService.save(disciplina.id(), disciplina.nome());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
