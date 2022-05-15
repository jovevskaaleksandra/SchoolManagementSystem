package finki.projects.schoolmanagementsystem181074.service;

import finki.projects.schoolmanagementsystem181074.model.Subject;
import finki.projects.schoolmanagementsystem181074.model.Teaching;
import finki.projects.schoolmanagementsystem181074.model.exceptions.SubjectNotFoundException;
import finki.projects.schoolmanagementsystem181074.model.exceptions.TeacherNotFoundException;
import finki.projects.schoolmanagementsystem181074.model.exceptions.TeachingNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

public interface TeachingService {
    List<Teaching> findAll();

    Optional<Teaching> findById(Integer id);

    Optional<Teaching> save(Teaching s) throws TeachingNotFoundException, SubjectNotFoundException, TeacherNotFoundException;

    void delete(Teaching s);
}
