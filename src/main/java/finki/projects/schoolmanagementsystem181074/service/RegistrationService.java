package finki.projects.schoolmanagementsystem181074.service;

import finki.projects.schoolmanagementsystem181074.model.Registration;
import finki.projects.schoolmanagementsystem181074.model.exceptions.StudentNotFoundException;

import java.util.List;
import java.util.Optional;

public interface RegistrationService {
    List<Registration> findAll();

    Optional<Registration> findById(Integer id);

    //Iterable<Registration> findByCId(Integer id);

    //Iterable<Registration> findByStudentId(Integer id);

    Optional<Registration> save(Registration s) throws StudentNotFoundException, ClassNotFoundException;

    void delete(Registration s);
}
