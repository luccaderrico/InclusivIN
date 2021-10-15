package school.cesar.InclusivIN.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.cesar.InclusivIN.dao.ExperienciasAnterioresDAO;
import school.cesar.InclusivIN.entities.ExperienciasAnteriores;

@Service
public class ExperienciasAnterioresService {

    @Autowired
    ExperienciasAnterioresDAO experienciasAnterioresDAO;

    public void cadastraExperiencias(ExperienciasAnteriores experiencia){

        experienciasAnterioresDAO.save(experiencia);

    }

}
