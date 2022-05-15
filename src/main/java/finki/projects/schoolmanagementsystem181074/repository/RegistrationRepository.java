package finki.projects.schoolmanagementsystem181074.repository;

import finki.projects.schoolmanagementsystem181074.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Registration, Integer> {
    //Iterable<Registration> findByCId(Integer id);

   // Iterable<Registration> findFirst5ByOrderByTimestampDesc();

    Iterable <Registration> findByStudentId(Integer id);


}
