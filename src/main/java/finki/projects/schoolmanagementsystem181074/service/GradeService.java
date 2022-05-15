package finki.projects.schoolmanagementsystem181074.service;

import finki.projects.schoolmanagementsystem181074.model.Grade;

import java.util.List;
import java.util.Optional;

public interface GradeService {
    List<Grade> findAll();

    Optional<Grade> findById(Integer id);

    Optional<Grade> save(Grade s);

    void delete(Grade s);
}
