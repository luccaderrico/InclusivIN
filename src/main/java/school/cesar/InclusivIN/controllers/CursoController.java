package school.cesar.InclusivIN.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.cesar.InclusivIN.entities.Curso;
import school.cesar.InclusivIN.services.CursoService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping("/add")
    public ResponseEntity<Void> cadastrar(@RequestBody Curso curso) throws URISyntaxException {
        cursoService.save(curso);
        return ResponseEntity.created(new URI("http://127.0.0.1:8081/curso/find/" + curso.getNome())).build();
    }

    @PatchMapping("/change")
    public ResponseEntity<Void> alterar(@RequestBody Curso curso) throws URISyntaxException {
        cursoService.save(curso);
        return ResponseEntity.created(new URI("http://127.0.0.1:8081/curso/find/" + curso.getNome())).build();
    }

    @GetMapping("/find/all")
    public ResponseEntity<List<Curso>> consultarTodos(){
        return ResponseEntity.ok().body(cursoService.findAll());
    }

    @GetMapping("/find/{curso}")
    public ResponseEntity<Curso> consultar(@PathVariable("curso") Curso curso){
        if (curso != null) {
            return ResponseEntity.ok().body(cursoService.find(curso));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{curso}")
    public ResponseEntity<Void> delete(@PathVariable("curso") Curso curso){
        if (curso != null) {
            cursoService.delete(curso);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
