package finki.projects.schoolmanagementsystem181074.service;

import finki.projects.schoolmanagementsystem181074.model.Subject;
import finki.projects.schoolmanagementsystem181074.model.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherService {
    List<Teacher> findAll();

    Optional<Teacher> findById(Integer id);

    Optional<Teacher> save(Teacher s);

    void delete(Teacher s);
}
