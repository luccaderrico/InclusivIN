package school.cesar.InclusivIN.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.cesar.InclusivIN.dao.CursoDAO;
import school.cesar.InclusivIN.entities.Curso;
import school.cesar.InclusivIN.exceptions.CursoInvalidoException;
import school.cesar.InclusivIN.util.CursoUtil;
import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoDAO cursoDAO;

    public void save(String cursoNome){
        Curso curso = new Curso();
        curso.setNomeCurso(cursoNome);
        cursoDAO.save(curso);
    }

    public void change(String nome, String novoNome){
        Curso cursoSelecionado;
        try {
            cursoSelecionado = CursoUtil.cursoExiste(nome, cursoDAO.findAll());
            cursoSelecionado.setNomeCurso(novoNome);

        } catch (NullPointerException e){
            throw new CursoInvalidoException("Curso não encontrado!");
        }
    }

    public List<Curso> findAll(){
        return cursoDAO.findAll();
    }

    public Curso find(String nomeCurso){
        for (Curso curso:cursoDAO.findAll()){
            if (curso.getNomeCurso().equals(nomeCurso)){
                return curso;
            }
        }
        return null;
    }

    public void remove(Curso curso){
        cursoDAO.delete(curso);
    }
}
