package finki.projects.schoolmanagementsystem181074.web;

import finki.projects.schoolmanagementsystem181074.exceptions.CourseNotFoundException;
import finki.projects.schoolmanagementsystem181074.exceptions.StudentAlreadyExistsException;
import finki.projects.schoolmanagementsystem181074.exceptions.StudentAlreadyInCourseException;
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
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;
    private final CourseService courseService;

    public StudentController(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

    @ModelAttribute("student")
    public Student student(Student studentById){
            return new Student();
    }

    @GetMapping
    public String findAll(Model model){
        List<Student> students = this.studentService.listAllStudents();
        model.addAttribute("students", students);
        return "students";
    }

    @GetMapping("/add-student-form")
    public String showAdd(Model model){
        List<Student> students = this.studentService.listAllStudents();
        model.addAttribute("students", students);
        return "add-student";
    }

    @GetMapping("/add-{id}-to-course-form")
    public String showAddStudentToCourse(@PathVariable Long id, Model model) throws StudentNotFoundException {
        List<Course> courses = this.courseService.listAllCourses();
        model.addAttribute("courses", courses);
        Student student = this.studentService.findStudentById(id);
        model.addAttribute("student", student);
        return "add-student-to-course";
    }

    @PostMapping
    public String create(Student student) throws StudentAlreadyExistsException {
        this.studentService.create(student);
        return "redirect:/student";
    }

    @PostMapping("/{id}")
    public String AddStudentToCourse (@ModelAttribute("student") @PathVariable Long id,@RequestParam List<Course> courses, Model model) throws StudentAlreadyInCourseException, CourseNotFoundException, StudentNotFoundException {
        this.studentService.addStudentToCourse(id,courses);
        model.addAttribute("courses", courses);
        return "redirect:/student";
    }



    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) throws StudentNotFoundException {
        this.studentService.deleteStudentById(id);
        return "redirect:/student";
    }
}
