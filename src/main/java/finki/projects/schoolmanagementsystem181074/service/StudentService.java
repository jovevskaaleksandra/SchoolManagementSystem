package finki.projects.schoolmanagementsystem181074.service;

import finki.projects.schoolmanagementsystem181074.exceptions.StudentAlreadyExistsException;
import finki.projects.schoolmanagementsystem181074.exceptions.StudentDoesNotExistException;
import finki.projects.schoolmanagementsystem181074.exceptions.StudentNotFoundException;
import finki.projects.schoolmanagementsystem181074.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Student create(Student student) throws StudentAlreadyExistsException;

    List<Student> listAllStudents();

    Student findStudentById(Long id) throws StudentNotFoundException;

    Student findStudentByIndex(String index) throws StudentDoesNotExistException;

    void deleteStudentById(Long id) throws StudentNotFoundException;
}
