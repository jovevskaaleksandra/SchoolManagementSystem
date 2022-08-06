package finki.projects.schoolmanagementsystem181074.service;

import finki.projects.schoolmanagementsystem181074.exceptions.CourseAlreadyExists;
import finki.projects.schoolmanagementsystem181074.exceptions.CourseNotFoundException;
import finki.projects.schoolmanagementsystem181074.model.Course;
import finki.projects.schoolmanagementsystem181074.model.Student;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface CourseService {
    Course findCourseById(Long id) throws CourseNotFoundException;

    List<Course> listAllCourses();

    Course addCourse (Course course) throws CourseAlreadyExists;

    void deleteCourseById(Long id) throws CourseNotFoundException;

    //void addStudentToCourse(Long id, Student student);

}
