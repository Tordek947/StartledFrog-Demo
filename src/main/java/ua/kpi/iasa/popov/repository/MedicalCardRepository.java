package ua.kpi.iasa.popov.repository;

import org.springframework.data.rest.webmvc.RepositoryRestController;
import ua.cmathtutor.startledfrog.repository.ContainableRepository;
import ua.kpi.iasa.popov.entity.MedicalCard;
import ua.kpi.iasa.popov.entity.Doctor;
import java.util.Set;
import ua.kpi.iasa.popov.entity.Patient;

@RepositoryRestController
public interface MedicalCardRepository extends ContainableRepository<MedicalCard> {

    Set<MedicalCard> findByCreator(Doctor creator);

    MedicalCard findByPatient(Patient patient);
}
