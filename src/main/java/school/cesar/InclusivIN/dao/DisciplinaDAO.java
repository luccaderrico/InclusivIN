package school.cesar.InclusivIN.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import school.cesar.InclusivIN.entities.Disciplina;

@Repository
public interface DisciplinaDAO extends JpaRepository<Disciplina, Long> {

}
