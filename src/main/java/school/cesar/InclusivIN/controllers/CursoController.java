package school.cesar.InclusivIN.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.cesar.InclusivIN.entities.Curso;
import school.cesar.InclusivIN.exceptions.CursoInvalidoException;
import school.cesar.InclusivIN.services.CursoService;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping("/add")
    public String cadastrar(@RequestBody String cursoNome){
        Curso curso = new Curso();
        curso.setNomeCurso(cursoNome);
        cursoService.save(curso);
        return "Curso Adicionado\nURI: http://127.0.0.1:8081/curso/find/" + cursoNome;
    }

    @PatchMapping("/change/{nomeCurso}")
    public ResponseEntity<String> alterar(@RequestBody String novoNome, @PathVariable String nomeCurso){
        Curso curso = cursoService.find(nomeCurso);
        if (curso != null) {
            cursoService.change(curso, novoNome);
            return ResponseEntity.ok().body("Curso Alterado com sucesso!\n" + curso + "\nNovo URI: http://127.0.0.1:8081/curso/find/" + novoNome);
        }
        return ResponseEntity.ok().body("Curso não encontrado!");
    }

    @GetMapping("/find/all")
    public ResponseEntity<List<Curso>> consultarTodos(){
        return ResponseEntity.ok().body(cursoService.findAll());
    }

    @GetMapping("/find/{nomeCurso}")
    public ResponseEntity<String> consultar(@PathVariable("nomeCurso") String nomeCurso){
        Curso curso = cursoService.find(nomeCurso);
        if (curso != null) {
            return ResponseEntity.ok().body(curso.toString());
        }
        return ResponseEntity.ok().body("Curso não encontrado!");
    }

    @DeleteMapping("/delete/{nomeCurso}")
    public ResponseEntity<String> delete(@PathVariable("nomeCurso") String nomeCurso){
        Curso curso = cursoService.find(nomeCurso);
        if (curso != null) {
            cursoService.delete(curso);
            return ResponseEntity.ok().body("Curso deletado");
        }
        return ResponseEntity.ok().body("Curso não encontrado!");
    }
}
