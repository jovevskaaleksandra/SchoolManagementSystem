package finki.projects.schoolmanagementsystem181074.service.impl;

import finki.projects.schoolmanagementsystem181074.exceptions.CourseAlreadyExists;
import finki.projects.schoolmanagementsystem181074.exceptions.CourseNotFoundException;
import finki.projects.schoolmanagementsystem181074.model.Course;
import finki.projects.schoolmanagementsystem181074.model.Teacher;
import finki.projects.schoolmanagementsystem181074.repository.CourseRepository;
import finki.projects.schoolmanagementsystem181074.repository.StudentRepository;
import finki.projects.schoolmanagementsystem181074.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    public CourseServiceImpl(CourseRepository courseRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public Course findCourseById(Long id) throws CourseNotFoundException {

        Optional<Course> course = courseRepository.findById(id);
        if(course.isEmpty()){
            throw new CourseNotFoundException("Course not found");
        }
        return course.get();
    }

    @Override
    public List<Course> listAllCourses() {
        return courseRepository.findAll();
    }
    //to be implemented
    @Override
    public Course addCourse(Course course) throws CourseAlreadyExists {
        Optional<Course> existingCourse = courseRepository.findByName(course.getName());
        if(existingCourse.isPresent()){
            throw new CourseAlreadyExists("Course already exists");
        }
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourseById(Long id) throws CourseNotFoundException {
        Optional<Course> course = courseRepository.findById(id);
        if(course.isEmpty()){
            throw new CourseNotFoundException("Course not found!");
        }
        courseRepository.delete(course.get());
    }




}
