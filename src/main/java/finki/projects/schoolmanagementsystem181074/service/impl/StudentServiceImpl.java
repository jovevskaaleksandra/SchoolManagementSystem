package finki.projects.schoolmanagementsystem181074.service.impl;

import finki.projects.schoolmanagementsystem181074.exceptions.*;
import finki.projects.schoolmanagementsystem181074.model.Course;
import finki.projects.schoolmanagementsystem181074.model.Student;
import finki.projects.schoolmanagementsystem181074.repository.CourseRepository;
import finki.projects.schoolmanagementsystem181074.repository.StudentRepository;
import finki.projects.schoolmanagementsystem181074.service.CourseService;
import finki.projects.schoolmanagementsystem181074.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final CourseService courseService;

    public StudentServiceImpl(StudentRepository studentRepository, CourseRepository courseRepository, CourseService courseService) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.courseService = courseService;
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
    public void deleteStudentById(Long id) throws StudentNotFoundException {
        Optional <Student> student = studentRepository.findById(id);
        if(student.isEmpty()){
            throw new StudentNotFoundException("Student not found");
        }
        studentRepository.delete(student.get());
    }

    @Override
    public void addStudentToCourse(Long studentId, List <Course> courses) throws StudentNotFoundException, CourseNotFoundException, StudentAlreadyInCourseException {
        Student newStudent = this.findStudentById(studentId);
        if(newStudent.getCourses().size() > 0){
            throw new StudentAlreadyInCourseException("Student is already added to this course");
        }
        newStudent.setCourses(courses);
        this.studentRepository.save(newStudent);
    }
}
