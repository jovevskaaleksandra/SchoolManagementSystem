package finki.projects.schoolmanagementsystem181074.service.impl;

import finki.projects.schoolmanagementsystem181074.model.*;
import finki.projects.schoolmanagementsystem181074.model.exceptions.LevelNotFoundException;
import finki.projects.schoolmanagementsystem181074.model.exceptions.RegistrationNotFoundException;
import finki.projects.schoolmanagementsystem181074.model.exceptions.SchoolNotFoundException;
import finki.projects.schoolmanagementsystem181074.model.exceptions.SchoolYearNotFoundException;
import finki.projects.schoolmanagementsystem181074.repository.ClassRepository;
import finki.projects.schoolmanagementsystem181074.repository.RegistrationRepository;
import finki.projects.schoolmanagementsystem181074.repository.StudentRepository;
import finki.projects.schoolmanagementsystem181074.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.Class;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private final RegistrationRepository registrationRepository;
    @Autowired
    private final ClassRepository classRepository;
    @Autowired
    private final StudentRepository studentRepository;

    public StudentServiceImpl(RegistrationRepository registrationRepository, ClassRepository classRepository, StudentRepository studentRepository) {
        this.registrationRepository = registrationRepository;
        this.classRepository = classRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return this.studentRepository.findAll();
    }

    @Override
    public Optional<Student> findById(Integer id){
        return this.studentRepository.findById(id);
    }

    @Override
    public Iterable<Student> findByNameContaining(String q){
        return this.studentRepository.findByNameContaining(q);
    }

    @Override
    public Iterable<Student> findByNameOrForenameContaining(String q, String m){
        return this.studentRepository.findByNameOrForenameContaining(q,m);
    }

    @Override
    @Transactional
    public Optional<Student> save(Student s) throws RegistrationNotFoundException, SchoolNotFoundException {
        Registration registration = this.registrationRepository.findById(s.getId())
                .orElseThrow(() -> new RegistrationNotFoundException());
        Class1 class1 = this.classRepository.findById(s.getId())
                .orElseThrow(() -> new SchoolNotFoundException(s.getId()));

        this.studentRepository.delete(s);
        return Optional.of(this.studentRepository.save(s));


    }
    @Override
    public void delete(Student s){
        this.studentRepository.delete(s);
    }

}
