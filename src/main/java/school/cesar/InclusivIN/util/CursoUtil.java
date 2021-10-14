package school.cesar.InclusivIN.util;

import school.cesar.InclusivIN.entities.Curso;
import java.util.List;

public class CursoUtil {

    public static Curso cursoExiste(String nomeCurso, List<Curso> list){
        for (Curso curso:list){
            if (curso.getNomeCurso().equals(nomeCurso)){
                return curso;
            }
        }
        return null;
    }
}
