package finki.projects.schoolmanagementsystem181074.service.impl;

import finki.projects.schoolmanagementsystem181074.model.Subject;
import finki.projects.schoolmanagementsystem181074.model.Teacher;
import finki.projects.schoolmanagementsystem181074.repository.TeacherRepository;
import finki.projects.schoolmanagementsystem181074.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Teacher> findAll() {
        return this.teacherRepository.findAll();
    }

    @Override
    public Optional<Teacher> findById(Integer id){
        return this.teacherRepository.findById(id);
    }

    @Override
    @Transactional
    public Optional<Teacher> save(Teacher s) {
        return Optional.of(this.teacherRepository.save(s));
    }

    @Override
    public void delete(Teacher s){
        this.teacherRepository.delete(s);
    }
}
