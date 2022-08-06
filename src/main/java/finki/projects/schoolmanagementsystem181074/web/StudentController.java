package finki.projects.schoolmanagementsystem181074.web;

import finki.projects.schoolmanagementsystem181074.exceptions.CourseAlreadyExists;
import finki.projects.schoolmanagementsystem181074.exceptions.CourseNotFoundException;
import finki.projects.schoolmanagementsystem181074.exceptions.StudentAlreadyExistsException;
import finki.projects.schoolmanagementsystem181074.exceptions.StudentNotFoundException;
import finki.projects.schoolmanagementsystem181074.model.Course;
import finki.projects.schoolmanagementsystem181074.model.Student;
import finki.projects.schoolmanagementsystem181074.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
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

    @PostMapping
    public String create(Student student) throws StudentAlreadyExistsException {
        this.studentService.create(student);
        return "redirect:/student";
    }

    //filter by index da se napravi


    @PostMapping("/{index}/delete")
    public String delete(@PathVariable String index) throws StudentNotFoundException {
        this.studentService.deleteStudentByIndex(index);
        return "redirect:/student";
    }
}
