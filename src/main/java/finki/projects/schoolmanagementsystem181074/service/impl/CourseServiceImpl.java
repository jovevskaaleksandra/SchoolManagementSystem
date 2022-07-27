package finki.projects.schoolmanagementsystem181074.service.impl;

import finki.projects.schoolmanagementsystem181074.model.Course;
import finki.projects.schoolmanagementsystem181074.repository.CourseRepository;
import finki.projects.schoolmanagementsystem181074.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Optional<Course> findCourseById(Long id) {
        return this.courseRepository.findById(id);
    }

    @Override
    public Optional<Course> findCourseByName(String name) {
        return this.courseRepository.findByName(name);
    }

    //to be implemented
    @Override
    public Optional<Course> saveCourse(String name, String description, Double credits, Boolean isEvenSemester) {
        return null;
    }
    //to be implemented
    @Override
    public Optional<Course> editCourse(Long id, String name, String description, Double credits, Boolean isEvenSemester) {
        return Optional.empty();
    }

    @Override
    public List<Course> listAllCourses(Long courseId) {
        return this.courseRepository.findAll();
    }
    //to be implemented
    @Override
    public Course addCourse(String name, String description, Double credits, Boolean isEvenSemester) {
        return null;
    }

    @Override
    public void deleteCourseById(Long id) {
        this.courseRepository.deleteById(id);
    }

    @Override
    public void deleteCourseByName(String name) {
        this.courseRepository.deleteByName(name);
    }
}
