package school.cesar.InclusivIN.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import school.cesar.InclusivIN.entities.ExperienciasAnteriores;

@Repository
public interface ExperienciasAnterioresDAO extends JpaRepository<ExperienciasAnteriores, Long> {
}
