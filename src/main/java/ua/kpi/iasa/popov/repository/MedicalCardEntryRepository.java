package ua.kpi.iasa.popov.repository;

import org.springframework.data.rest.webmvc.RepositoryRestController;
import ua.cmathtutor.startledfrog.repository.ContainableRepository;
import ua.kpi.iasa.popov.entity.MedicalCardEntry;
import ua.kpi.iasa.popov.entity.Doctor;
import java.util.Set;
import ua.kpi.iasa.popov.entity.MedicalCard;

@RepositoryRestController
public interface MedicalCardEntryRepository extends ContainableRepository<MedicalCardEntry> {

    Set<MedicalCardEntry> findByEntryCreator(Doctor entryCreator);

    Set<MedicalCardEntry> findByMedicalCard(MedicalCard medicalCard);
}
