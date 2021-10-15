package school.cesar.InclusivIN.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import school.cesar.InclusivIN.entities.Curso;

@Repository
public interface CursoDAO extends JpaRepository<Curso, Long> {

}
