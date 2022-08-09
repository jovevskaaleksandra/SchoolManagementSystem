package finki.projects.schoolmanagementsystem181074.service.impl;

import finki.projects.schoolmanagementsystem181074.exceptions.TeacherAlreadyExistsException;
import finki.projects.schoolmanagementsystem181074.exceptions.TeacherNotFoundException;
import finki.projects.schoolmanagementsystem181074.model.Teacher;
import finki.projects.schoolmanagementsystem181074.repository.TeacherRepository;
import finki.projects.schoolmanagementsystem181074.service.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Teacher create(Teacher teacher) throws TeacherAlreadyExistsException {
        Optional<Teacher> existingTeacher = teacherRepository.findById(teacher.getId());
        if(existingTeacher.isPresent()){
            throw new TeacherAlreadyExistsException("Teacher already exists");
        }
        return teacherRepository.save(teacher);
    }

    @Override
    public List<Teacher> listAllTeachers() {
        return this.teacherRepository.findAll();
    }

    @Override
    public Teacher findTeacherById(Long id) throws TeacherNotFoundException {
        Optional<Teacher> teacher = this.teacherRepository.findById(id);
        if(teacher.isEmpty()){
            throw  new TeacherNotFoundException("Teacher not found");
        }
        return teacher.get();
    }

    @Override
    public void deleteTeacherById(Long id) throws TeacherNotFoundException {
        Optional<Teacher> teacher = this.teacherRepository.findById(id);
        if(teacher.isEmpty()){
            throw  new TeacherNotFoundException("Teacher not found");
        }
        teacherRepository.delete(teacher.get());
    }
}
