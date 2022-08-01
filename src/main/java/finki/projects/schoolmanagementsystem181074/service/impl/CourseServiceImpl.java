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
    public List<Course> listAllCourses() {
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


}
