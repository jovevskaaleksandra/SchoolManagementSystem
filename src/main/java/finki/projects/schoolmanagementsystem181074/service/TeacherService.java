package finki.projects.schoolmanagementsystem181074.service;

import finki.projects.schoolmanagementsystem181074.exceptions.*;
import finki.projects.schoolmanagementsystem181074.model.Student;
import finki.projects.schoolmanagementsystem181074.model.Teacher;

import java.util.List;

public interface TeacherService {

    Teacher create(Teacher teacher) throws TeacherAlreadyExistsException;

    List<Teacher> listAllTeachers();

    Teacher findTeacherById(Long id) throws TeacherNotFoundException;

    void deleteTeacherById(Long id) throws TeacherNotFoundException;
}
