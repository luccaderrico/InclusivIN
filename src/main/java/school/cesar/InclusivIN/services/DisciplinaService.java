package school.cesar.InclusivIN.services;


import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.cesar.InclusivIN.dao.DisciplinaDAO;
import school.cesar.InclusivIN.entities.Curso;
import school.cesar.InclusivIN.entities.Disciplina;

import java.util.List;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaDAO disciplinaDAO;

    public void save (Disciplina disciplina){disciplinaDAO.save(disciplina);}


    public void change(Disciplina disciplina, String novaDisciplina){
        disciplina.setNomeDisciplina(novaDisciplina);
    }
    public List<Disciplina> findAll(){return disciplinaDAO.findAll();
    }
}
