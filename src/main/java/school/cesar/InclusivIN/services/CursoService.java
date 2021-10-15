package school.cesar.InclusivIN.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.cesar.InclusivIN.dao.CursoDAO;
import school.cesar.InclusivIN.entities.Curso;
import school.cesar.InclusivIN.util.CursoUtil;
import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoDAO cursoDAO;

    public void save(Curso curso){
        cursoDAO.save(curso);
    }

    public List<Curso> findAll(){
        return cursoDAO.findAll();
    }

    public Curso find(Curso curso){
       return cursoDAO.findById(curso.getId()).get();
    }

    public void delete(Curso curso){
        cursoDAO.delete(curso);
    }
}
