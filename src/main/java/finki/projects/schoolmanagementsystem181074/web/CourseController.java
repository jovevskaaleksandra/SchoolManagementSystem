package finki.projects.schoolmanagementsystem181074.web;

import finki.projects.schoolmanagementsystem181074.model.Course;
import finki.projects.schoolmanagementsystem181074.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public String findAll(Model model){
        List<Course> courses = this.courseService.listAllCourses();
        model.addAttribute("courses", courses);
        return "master-template";
    }

//
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
////        modelAndView.setViewName("master-template.html");
////          return modelAndView;
//        return "master-template";
//    }
//    @RequestMapping("/all")
//    public ModelAndView all(){
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("master-template.html");
//          return modelAndView;
//    }

//
//    @GetMapping(value = "/all")
//  //  public ResponseEntity<List<Course>> getAllCourses(){
//        List<Course> courses = courseService.listAllCourses();
//        return new ResponseEntity<>(courses, HttpStatus.OK);
//    }


}
