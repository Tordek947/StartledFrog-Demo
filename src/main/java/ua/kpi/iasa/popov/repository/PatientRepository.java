package ua.kpi.iasa.popov.repository;

import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.repository.CrudRepository;
import ua.kpi.iasa.popov.entity.Patient;

@RepositoryRestController
public interface PatientRepository extends CrudRepository<Patient, Long> {
}
