package finki.projects.schoolmanagementsystem181074.service.impl;

import finki.projects.schoolmanagementsystem181074.model.*;
import finki.projects.schoolmanagementsystem181074.model.exceptions.LevelNotFoundException;
import finki.projects.schoolmanagementsystem181074.model.exceptions.RegistrationNotFoundException;
import finki.projects.schoolmanagementsystem181074.model.exceptions.SchoolNotFoundException;
import finki.projects.schoolmanagementsystem181074.model.exceptions.SchoolYearNotFoundException;
import finki.projects.schoolmanagementsystem181074.repository.*;
import finki.projects.schoolmanagementsystem181074.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClassServiceImpl implements ClassService {

    private final ClassRepository classRepository;

    private final SchoolYearRepository schoolYearRepository;

    private final SchoolRepository schoolRepository;

    private final LevelRepository levelRepository;

    private final RegistrationRepository registrationRepository;

    public ClassServiceImpl(ClassRepository classRepository, SchoolYearRepository schoolYearRepository, SchoolRepository schoolRepository, LevelRepository levelRepository, RegistrationRepository registrationRepository) {
        this.classRepository = classRepository;
        this.schoolYearRepository = schoolYearRepository;
        this.schoolRepository = schoolRepository;
        this.levelRepository = levelRepository;
        this.registrationRepository = registrationRepository;
    }

    @Override
    public List<Class1> findAll() {
        return this.classRepository.findAll();
    }

    @Override
    public Optional<Class1> findById(Integer id){
        return this.classRepository.findById(id);
    }

    //@Override
    //public Optional<Class1> findByCId(Integer id){
        //return this.classRepository.findByCId(id);
    //}

    @Override
    public Iterable<Class1> findByNameContaining(String q){
        return this.classRepository.findByNameContaining(q);
    }

    @Override
    @Transactional
    public Optional<Class1> save(Class1 s) throws SchoolYearNotFoundException, SchoolNotFoundException, LevelNotFoundException, RegistrationNotFoundException {
        SchoolYear schoolYear = this.schoolYearRepository.findById(s.getId())
                .orElseThrow(()-> new SchoolYearNotFoundException());
        School school = this.schoolRepository.findById(s.getId())
                .orElseThrow(()-> new SchoolNotFoundException(s.getId()));
        Level level = this.levelRepository.findById(s.getId())
                .orElseThrow(() -> new LevelNotFoundException(s.getId()));
        Registration registration = this.registrationRepository.findById(s.getId())
                .orElseThrow(() -> new RegistrationNotFoundException(s.getId()));

        this.classRepository.delete(s);
        return Optional.of(this.classRepository.save(s));

    }

    @Override
    public void delete(Class1 s) {
        this.classRepository.delete(s);
    }

}
