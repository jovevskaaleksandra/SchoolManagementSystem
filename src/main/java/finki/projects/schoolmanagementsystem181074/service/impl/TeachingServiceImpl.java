package finki.projects.schoolmanagementsystem181074.service.impl;

import finki.projects.schoolmanagementsystem181074.model.*;
import finki.projects.schoolmanagementsystem181074.model.exceptions.*;
import finki.projects.schoolmanagementsystem181074.repository.ClassRepository;
import finki.projects.schoolmanagementsystem181074.repository.SubjectRepository;
import finki.projects.schoolmanagementsystem181074.repository.TeacherRepository;
import finki.projects.schoolmanagementsystem181074.repository.TeachingRepository;
import finki.projects.schoolmanagementsystem181074.service.TeachingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.Class;
import java.util.List;
import java.util.Optional;

@Service
public class TeachingServiceImpl implements TeachingService {
    @Autowired
    private final TeachingRepository teachingRepository;
    @Autowired
    private final SubjectRepository subjectRepository;
    @Autowired
    private final TeacherRepository teacherRepository;
    @Autowired
    private final ClassRepository classRepository;

    public TeachingServiceImpl(TeachingRepository teachingRepository, SubjectRepository subjectRepository, TeacherRepository teacherRepository, ClassRepository classRepository) {
        this.teachingRepository = teachingRepository;
        this.subjectRepository = subjectRepository;
        this.teacherRepository = teacherRepository;
        this.classRepository = classRepository;
    }

    @Override
    public List<Teaching> findAll() {
        return this.teachingRepository.findAll();
    }

    @Override
    public Optional<Teaching> findById(Integer id){
        return this.teachingRepository.findById(id);
    }

    @Override
    @Transactional
    public Optional<Teaching> save(Teaching s) throws TeachingNotFoundException, SubjectNotFoundException, TeacherNotFoundException {
        Teaching teaching = this.teachingRepository.findById(s.getId())
                .orElseThrow(() -> new TeachingNotFoundException(s.getId()));
        Subject subject = this.subjectRepository.findById(s.getId())
                .orElseThrow(() -> new SubjectNotFoundException(s.getId()));

        Teacher teacher = this.teacherRepository.findById(s.getId())
                .orElseThrow(() -> new TeacherNotFoundException(s.getId()));

        this.teachingRepository.delete(s);
        return Optional.of(this.teachingRepository.save(s));

    }
    @Override
    public void delete(Teaching s){
        this.teachingRepository.delete(s);
    }
}
