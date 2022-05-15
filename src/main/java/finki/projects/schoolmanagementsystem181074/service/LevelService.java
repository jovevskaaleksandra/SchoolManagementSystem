package finki.projects.schoolmanagementsystem181074.service;

import finki.projects.schoolmanagementsystem181074.model.Grade;
import finki.projects.schoolmanagementsystem181074.model.Level;

import java.util.List;
import java.util.Optional;

public interface LevelService {
    List<Level> findAll();

    Optional<Level> findById(Integer id);

    Optional<Level> save(Level s);

    void delete(Level s);
}
