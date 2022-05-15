package finki.projects.schoolmanagementsystem181074.service.impl;

import finki.projects.schoolmanagementsystem181074.model.*;
import finki.projects.schoolmanagementsystem181074.model.exceptions.*;
import finki.projects.schoolmanagementsystem181074.repository.ClassRepository;
import finki.projects.schoolmanagementsystem181074.repository.RegistrationRepository;
import finki.projects.schoolmanagementsystem181074.repository.StudentRepository;
import finki.projects.schoolmanagementsystem181074.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.ClassNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    @Autowired
    private final RegistrationRepository registrationRepository;
    @Autowired
    private final ClassRepository classRepository;
    @Autowired
    private final StudentRepository studentRepository;

    public RegistrationServiceImpl(RegistrationRepository registrationRepository, ClassRepository classRepository, StudentRepository studentRepository) {
        this.registrationRepository = registrationRepository;
        this.classRepository = classRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Registration> findAll() {
        return this.registrationRepository.findAll();
    }

    @Override
    public Optional<Registration> findById(Integer id){
        return this.registrationRepository.findById(id);
    }

    @Override
    public Iterable<Registration> findByStudentId(Integer id){
        return this.registrationRepository.findByStudentId(id);
    }

    @Override
    public Optional<Registration> save(Registration s) throws StudentNotFoundException, ClassNotFoundException {
        Student student = this.studentRepository.findById(s.getId())
                .orElseThrow(() -> new StudentNotFoundException(s.getId()));
        //Class1 class = this.classRepository.findById(s.getId())
                //.orElseThrow(() -> new ClassNotFoundException());

        this.registrationRepository.delete(s);
        return Optional.of(this.registrationRepository.save(s));
    }

    //@Override
    //public Iterable<Registration> findByCId(Integer id){
        //return this.registrationRepository.findByCId(id);
    //}

    @Override
    public void delete(Registration s){
        this.registrationRepository.delete(s);
    }
}
