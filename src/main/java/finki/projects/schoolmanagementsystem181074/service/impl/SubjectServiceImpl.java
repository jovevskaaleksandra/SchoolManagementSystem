package finki.projects.schoolmanagementsystem181074.service.impl;

import finki.projects.schoolmanagementsystem181074.model.Subject;
import finki.projects.schoolmanagementsystem181074.repository.SubjectRepository;
import finki.projects.schoolmanagementsystem181074.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private final SubjectRepository subjectRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public List<Subject> findAll() {
        return this.subjectRepository.findAll();
    }

    @Override
    public Optional<Subject> findById(Integer id){
        return this.subjectRepository.findById(id);
    }

    @Override
    @Transactional
    public Optional<Subject> save(Subject s){
        return Optional.of(this.subjectRepository.save(s));
    }

    @Override
    public void delete(Subject s){
        this.subjectRepository.delete(s);
    }
}
