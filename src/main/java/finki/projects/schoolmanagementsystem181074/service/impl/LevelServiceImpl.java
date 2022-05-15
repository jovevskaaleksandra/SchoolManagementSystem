package finki.projects.schoolmanagementsystem181074.service.impl;

import finki.projects.schoolmanagementsystem181074.model.Level;
import finki.projects.schoolmanagementsystem181074.repository.LevelRepository;
import finki.projects.schoolmanagementsystem181074.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class LevelServiceImpl implements LevelService {
    @Autowired
    private final LevelRepository levelRepository;

    public LevelServiceImpl(LevelRepository levelRepository) {
        this.levelRepository = levelRepository;
    }

    @Override
    public List<Level> findAll() {
        return this.levelRepository.findAll();
    }

    @Override
    public Optional<Level> findById(Integer id){
        return this.levelRepository.findById(id);
    }

    @Override
    @Transactional
    public Optional<Level> save(Level s){
        return Optional.of(this.levelRepository.save(s));
    }

    @Override
    public void delete(Level s){
        this.levelRepository.delete(s);
    }
}
