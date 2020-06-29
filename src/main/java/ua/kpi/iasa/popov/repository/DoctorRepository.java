package ua.kpi.iasa.popov.repository;

import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.repository.CrudRepository;
import ua.kpi.iasa.popov.entity.Doctor;

@RepositoryRestController
public interface DoctorRepository extends CrudRepository<Doctor, Long> {
}
