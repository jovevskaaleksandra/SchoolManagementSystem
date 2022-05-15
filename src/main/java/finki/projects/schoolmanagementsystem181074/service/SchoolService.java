package finki.projects.schoolmanagementsystem181074.service;

import finki.projects.schoolmanagementsystem181074.model.Level;
import finki.projects.schoolmanagementsystem181074.model.Registration;
import finki.projects.schoolmanagementsystem181074.model.School;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface SchoolService {
    List<School> findAll();

    Optional<School> findById(Integer id);

    Optional<School> save(School s);

    void delete(School s);
}
