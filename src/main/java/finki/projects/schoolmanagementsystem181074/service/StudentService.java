package finki.projects.schoolmanagementsystem181074.service;

import finki.projects.schoolmanagementsystem181074.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Student create(String index, String name, String surname);

    List<Student> listAllStudents();

    Optional<Student> findStudentById(Long id);

    Optional<Student> findStudentByIndex(String index);

    Optional<Student> saveStudent(String index,String name, String surname);

    void deleteStudentByIndex(String index);
}
