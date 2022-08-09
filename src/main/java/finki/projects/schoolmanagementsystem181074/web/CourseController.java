package finki.projects.schoolmanagementsystem181074.web;

import finki.projects.schoolmanagementsystem181074.exceptions.CourseAlreadyExists;
import finki.projects.schoolmanagementsystem181074.exceptions.CourseNotFoundException;
import finki.projects.schoolmanagementsystem181074.exceptions.StudentNotFoundException;
import finki.projects.schoolmanagementsystem181074.model.Course;
import finki.projects.schoolmanagementsystem181074.model.Student;
import finki.projects.schoolmanagementsystem181074.service.CourseService;
import finki.projects.schoolmanagementsystem181074.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;
    private final StudentService studentService;

    public CourseController(CourseService courseService, StudentService studentService) {
        this.courseService = courseService;
        this.studentService = studentService;
    }

    @GetMapping
    public String findAll(Model model){
        List<Course> courses = this.courseService.listAllCourses();
        model.addAttribute("courses", courses);
        return "courses";
    }

    @GetMapping("/add-course-form")
    public String showAdd(Model model){
        List<Course> courses = this.courseService.listAllCourses();
        model.addAttribute("courses", courses);
        return "add-course";
    }

    @GetMapping("/add-student-to-course-form")
    public String showAddStudentToCourse(Model model){
        List<Course> courses = this.courseService.listAllCourses();
        model.addAttribute("courses", courses);
        return "add-student-to-course-form";
    }

    @PostMapping
    public String create(Course course) throws CourseAlreadyExists {
        this.courseService.addCourse(course);
        return "redirect:/course";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) throws CourseNotFoundException {
        this.courseService.deleteCourseById(id);
        return "redirect:/course";
    }

    @PostMapping("/add-student/{courseId}/to/{studentId}")
    public String addStudentToCourse(@PathVariable Long courseId, @PathVariable Long studentId) throws StudentNotFoundException, CourseNotFoundException {
        courseService.addStudentToCourse(courseId,studentId);
        return "redirect:/course";
    }

//isEvenSemester
//    private final CourseService courseService;
//
//    @Autowired
//    CourseRepository courseRepository;
//
//    @Autowired
//    public CourseController(CourseService courseService) {
//        this.courseService = courseService;
//    }

//
//    @GetMapping
//    public Iterable<Course> getAllCourses(){
//        return courseRepository.findAll();
//    }
//
//    @GetMapping("/test")
//    public String findAll(Model model)
//    {
//        //model.addAttribute("courses",co)
////        ModelAndView modelAndView = new ModelAndView();
////        modelAndView.setViewName("courses.html");
////          return modelAndView;
//        return "master-template";
//    }
//    @RequestMapping("/all")
//    public ModelAndView all(){
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("courses.html");
//          return modelAndView;
//    }

//
//    @GetMapping(value = "/all")
//  //  public ResponseEntity<List<Course>> getAllCourses(){
//        List<Course> courses = courseService.listAllCourses();
//        return new ResponseEntity<>(courses, HttpStatus.OK);
//    }


}
