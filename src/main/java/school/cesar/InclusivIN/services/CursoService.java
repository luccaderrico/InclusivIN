package school.cesar.InclusivIN.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.cesar.InclusivIN.dao.CursoDAO;
import school.cesar.InclusivIN.entities.Curso;
import school.cesar.InclusivIN.exceptions.CursoInvalidoException;
import school.cesar.InclusivIN.util.CursoUtil;
import java.util.List;
import java.util.Scanner;

@Service
public class CursoService {

    @Autowired
    private CursoDAO cursoDAO;

    public void save(Curso curso){
        cursoDAO.save(curso);
    }

    public void change(Curso curso, String novoNome){
        curso.setNomeCurso(novoNome);
    }

    public List<Curso> findAll(){
        return cursoDAO.findAll();
    }

    public Curso find(String nomeCurso){
        Curso cursoSelecionado;
        cursoSelecionado = CursoUtil.cursoExiste(nomeCurso, cursoDAO.findAll());
        return cursoSelecionado;
    }

    public void delete(Curso curso){
        cursoDAO.delete(curso);
    }
}
