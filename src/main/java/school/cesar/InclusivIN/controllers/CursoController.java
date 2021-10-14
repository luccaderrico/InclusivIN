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

    @GetMapping("/all")
    public ResponseEntity<List<Curso>> findAll(){
        return ResponseEntity.ok().body(cursoService.findAll());
    }

    @GetMapping("/{}")
    public ResponseEntity<Curso> find(@PathVariable String nomeCurso){
        return ResponseEntity.ok().body(cursoService.find(nomeCurso));
    }

    @PostMapping("/")
    public ResponseEntity<Void> save(@RequestBody String cursoNome) throws URISyntaxException{
        cursoService.save(cursoNome);
        return ResponseEntity.created(new URI("http://127.0.0.1:3306/curso/" + cursoNome)).build();
    }

    @PatchMapping("/change")
    public ResponseEntity<Void> change(@RequestBody String nomeCurso, String novoNome) throws URISyntaxException{
        cursoService.change(nomeCurso, novoNome);
        return ResponseEntity.created(new URI("http://127.0.0.1:3306/curso/" + novoNome)).build();
    }

}
