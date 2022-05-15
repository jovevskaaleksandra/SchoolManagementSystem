package finki.projects.schoolmanagementsystem181074.service.impl;

import finki.projects.schoolmanagementsystem181074.model.Level;
import finki.projects.schoolmanagementsystem181074.model.School;
import finki.projects.schoolmanagementsystem181074.repository.SchoolRepository;
import finki.projects.schoolmanagementsystem181074.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class SchoolServiceImpl implements SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;

    @Override
    public List<School> findAll() {
        return this.schoolRepository.findAll();
    }

    @Override
    public Optional<School> findById(Integer id){
        return this.schoolRepository.findById(id);
    }

    @Override
    @Transactional
    public Optional<School> save(School s) {
        return Optional.of(this.schoolRepository.save(s));
    }

    @Override
    public void delete(School s){
        this.schoolRepository.delete(s);
    }
}
