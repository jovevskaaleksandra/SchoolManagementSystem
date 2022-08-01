package finki.projects.schoolmanagementsystem181074.service.impl;

import finki.projects.schoolmanagementsystem181074.exceptions.StudentAlreadyExistsException;
import finki.projects.schoolmanagementsystem181074.exceptions.StudentDoesNotExistException;
import finki.projects.schoolmanagementsystem181074.exceptions.StudentNotFoundException;
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
    public Student create(Student student) throws StudentAlreadyExistsException {

        Optional<Student> existingStudent = studentRepository.findByIndex(student.getIndex());
        if(existingStudent.isPresent()){
            throw new StudentAlreadyExistsException("Student already exists");
        }
        return studentRepository.save(student);
    }

    @Override
    public List<Student> listAllStudents() {
        return this.studentRepository.findAll();
    }

    @Override
    public Student findStudentById(Long id) throws StudentNotFoundException {
        Optional<Student> student = studentRepository.findById(id);
        if(student.isEmpty()){
            throw new StudentNotFoundException("Student not found");
        }
        return student.get();
    }


    @Override
    public Student findStudentByIndex(String index) throws StudentDoesNotExistException {
        Optional<Student> student = studentRepository.findByIndex(index);
        if(student.isEmpty()){
            throw new StudentDoesNotExistException("Student does not exist");
        }
        return student.get();

    }

    @Override
    public void deleteStudentByIndex(String index) throws StudentNotFoundException {
        Optional <Student> student = studentRepository.findByIndex(index);
        if(student.isEmpty()){
            throw new StudentNotFoundException("Student not found");
        }
        studentRepository.delete(student.get());
    }
}
