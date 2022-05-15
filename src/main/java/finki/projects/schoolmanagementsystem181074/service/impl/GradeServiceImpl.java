package finki.projects.schoolmanagementsystem181074.service.impl;

import finki.projects.schoolmanagementsystem181074.model.*;
import finki.projects.schoolmanagementsystem181074.repository.GradeRepository;
import finki.projects.schoolmanagementsystem181074.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class GradeServiceImpl implements GradeService{
    @Autowired
    private final GradeRepository gradeRepository;

    public GradeServiceImpl(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    @Override
    public List<Grade> findAll() {
        return this.gradeRepository.findAll();
    }

    @Override
    public Optional<Grade> findById(Integer id){
        return this.gradeRepository.findById(id);
    }

    @Override
    @Transactional
    public Optional<Grade> save(Grade s){
        return Optional.of(this.gradeRepository.save(s));
    }

    @Override
    public void delete(Grade s){
        this.gradeRepository.delete(s);
    }
}
