package finki.projects.schoolmanagementsystem181074.web;

import finki.projects.schoolmanagementsystem181074.exceptions.CourseAlreadyExists;
import finki.projects.schoolmanagementsystem181074.exceptions.CourseNotFoundException;
import finki.projects.schoolmanagementsystem181074.model.Course;
import finki.projects.schoolmanagementsystem181074.model.Teacher;
import finki.projects.schoolmanagementsystem181074.service.CourseService;
import finki.projects.schoolmanagementsystem181074.service.StudentService;
import finki.projects.schoolmanagementsystem181074.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;
    private final StudentService studentService;
    private final TeacherService teacherService;

    public CourseController(CourseService courseService, StudentService studentService, TeacherService teacherService) {
        this.courseService = courseService;
        this.studentService = studentService;
        this.teacherService = teacherService;
    }

    @ModelAttribute("course")
    public Course course(){
        return new Course();
    }

    @GetMapping
    public String findAll(Model model){
        List<Course> courses = this.courseService.listAllCourses();
        System.out.println(courses);
        model.addAttribute("courses", courses);
        return "courses";
    }

    @GetMapping("/add-course-form")
    public String showAdd(Model model){
        List<Teacher> teachers = this.teacherService.listAllTeachers();
        model.addAttribute("teachers", teachers);
        return "add-course";
    }

    @PostMapping
    public String create(@ModelAttribute("course") @RequestBody Course course, Model model) throws CourseAlreadyExists {
        this.courseService.addCourse(course);
        model.addAttribute("teacher", "");
        return "redirect:/course";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) throws CourseNotFoundException {
        this.courseService.deleteCourseById(id);
        return "redirect:/course";
    }





}
