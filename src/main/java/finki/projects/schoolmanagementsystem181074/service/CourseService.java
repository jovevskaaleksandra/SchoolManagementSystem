package finki.projects.schoolmanagementsystem181074.service;

import finki.projects.schoolmanagementsystem181074.model.Course;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface CourseService {
    Optional<Course> findCourseById(Long id);

    List<Course> listAllCourses();

    Course addCourse (String name, String description, Double credits, Boolean isEvenSemester);

    void deleteCourseById(Long id);

}
