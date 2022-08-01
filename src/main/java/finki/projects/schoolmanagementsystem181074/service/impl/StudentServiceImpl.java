package finki.projects.schoolmanagementsystem181074.service.impl;

import finki.projects.schoolmanagementsystem181074.model.Student;
import finki.projects.schoolmanagementsystem181074.repository.StudentRepository;
import finki.projects.schoolmanagementsystem181074.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student create(String index, String name, String surname) {
        return null;
    }

    @Override
    public List<Student> listAllStudents() {
        return this.studentRepository.findAll();
    }

    @Override
    public Optional<Student> findStudentById(Long id) {
        return this.studentRepository.findById(id);
    }

    @Override
    public Optional<Student> findStudentByIndex(String index) {
        return this.studentRepository.findByIndex(index);
    }

    @Override
    public Optional<Student> saveStudent(String index, String name, String surname) {
        return Optional.empty();
    }

    @Override
    public void deleteStudentByIndex(String index) {
        this.studentRepository.deleteByIndex(index);
    }
}
