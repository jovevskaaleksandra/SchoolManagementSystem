package finki.projects.schoolmanagementsystem181074.service;

import finki.projects.schoolmanagementsystem181074.model.Class1;
import finki.projects.schoolmanagementsystem181074.model.exceptions.LevelNotFoundException;
import finki.projects.schoolmanagementsystem181074.model.exceptions.RegistrationNotFoundException;
import finki.projects.schoolmanagementsystem181074.model.exceptions.SchoolNotFoundException;
import finki.projects.schoolmanagementsystem181074.model.exceptions.SchoolYearNotFoundException;

import java.util.List;
import java.util.Optional;

public interface ClassService {

    List<Class1> findAll();

    Optional<Class1> findById(Integer id);

    //Optional<Class1> findByCId(Integer id);

    Iterable<Class1> findByNameContaining(String q);

    Optional<Class1> save(Class1 s) throws SchoolYearNotFoundException, SchoolNotFoundException, LevelNotFoundException, RegistrationNotFoundException;

    void delete(Class1 s);

}
