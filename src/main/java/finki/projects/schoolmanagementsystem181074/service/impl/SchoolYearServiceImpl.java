package finki.projects.schoolmanagementsystem181074.service.impl;

import finki.projects.schoolmanagementsystem181074.model.SchoolYear;
import finki.projects.schoolmanagementsystem181074.repository.SchoolYearRepository;
import finki.projects.schoolmanagementsystem181074.service.SchoolYearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class SchoolYearServiceImpl implements SchoolYearService {
    @Autowired
    private final SchoolYearRepository schoolYearRepository;

    public SchoolYearServiceImpl(SchoolYearRepository schoolYearRepository) {
        this.schoolYearRepository = schoolYearRepository;
    }

    @Override
    public List<SchoolYear> findAll() {
        return this.schoolYearRepository.findAll();
    }

    @Override
    public Optional<SchoolYear> findById(Integer id) {
        return this.schoolYearRepository.findById(id);
    }

    @Override
    @Transactional
    public Optional<SchoolYear> save(SchoolYear s){
        return Optional.of(this.schoolYearRepository.save(s));
    }

    @Override
    public void delete(SchoolYear s){
        this.schoolYearRepository.delete(s);
    }
}
