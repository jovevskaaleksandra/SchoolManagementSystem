package finki.projects.schoolmanagementsystem181074.service;

import finki.projects.schoolmanagementsystem181074.model.Student;
import finki.projects.schoolmanagementsystem181074.model.Subject;

import java.util.List;
import java.util.Optional;

public interface SubjectService {
    List<Subject> findAll();

    Optional<Subject> findById(Integer id);

    Optional<Subject> save(Subject s);

    void delete(Subject s);
}
