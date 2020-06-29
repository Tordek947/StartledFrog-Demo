package ua.kpi.iasa.popov.repository;

import org.springframework.data.rest.webmvc.RepositoryRestController;
import ua.cmathtutor.startledfrog.repository.ContainableRepository;
import ua.kpi.iasa.popov.entity.HealthIndex;
import ua.kpi.iasa.popov.entity.MedicalCardEntry;
import java.util.Set;

@RepositoryRestController
public interface HealthIndexRepository extends ContainableRepository<HealthIndex> {

    Set<HealthIndex> findByMedicalCardEntry(MedicalCardEntry medicalCardEntry);
}
