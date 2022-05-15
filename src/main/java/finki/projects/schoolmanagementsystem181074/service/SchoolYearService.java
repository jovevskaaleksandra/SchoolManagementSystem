package finki.projects.schoolmanagementsystem181074.service;

import finki.projects.schoolmanagementsystem181074.model.SchoolYear;

import java.util.List;
import java.util.Optional;

public interface SchoolYearService {
    List<SchoolYear> findAll();

    Optional<SchoolYear> findById(Integer id);

    Optional<SchoolYear> save(SchoolYear s);

    void delete(SchoolYear s);
}
