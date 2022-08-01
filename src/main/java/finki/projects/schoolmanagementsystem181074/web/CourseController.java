package finki.projects.schoolmanagementsystem181074.web;

import finki.projects.schoolmanagementsystem181074.model.Course;
import finki.projects.schoolmanagementsystem181074.service.CourseService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("")
    public String findAll(Model model)
    {
        List<Course> courses = this.courseService.listAllCourses();
        model.addAttribute("courses", courses);
        return "master-template";
    }



}
