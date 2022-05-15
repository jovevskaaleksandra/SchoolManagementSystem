package finki.projects.schoolmanagementsystem181074.service;

import finki.projects.schoolmanagementsystem181074.model.Registration;
import finki.projects.schoolmanagementsystem181074.model.Student;
import finki.projects.schoolmanagementsystem181074.model.exceptions.RegistrationNotFoundException;
import finki.projects.schoolmanagementsystem181074.model.exceptions.SchoolNotFoundException;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> findAll();

    Optional<Student> findById(Integer id);

    Iterable<Student> findByNameContaining(String q);

    Iterable<Student> findByNameOrForenameContaining(String q, String m);

    Optional<Student> save(Student s) throws RegistrationNotFoundException, SchoolNotFoundException;

    void delete(Student s);
}
