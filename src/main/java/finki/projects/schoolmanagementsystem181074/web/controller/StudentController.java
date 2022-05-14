package finki.projects.schoolmanagementsystem181074.web.controller;

import finki.projects.schoolmanagementsystem181074.model.Registration;
import finki.projects.schoolmanagementsystem181074.model.Student;
import finki.projects.schoolmanagementsystem181074.model.exceptions.StudentNotFoundException;
import finki.projects.schoolmanagementsystem181074.service.GradeService;
import finki.projects.schoolmanagementsystem181074.service.RegistrationService;
import finki.projects.schoolmanagementsystem181074.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path="/student")
public class StudentController {

    private final StudentService studentService;

    private final RegistrationService registrationService;

    private final GradeService gradeService;

    @GetMapping("/dashboard")
    public String studentIndex(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("students", studentService.findAll());
        return "student/dashboard";
    }

    @GetMapping(path="/{id}")
    public String getStudent (@PathVariable(value = "id") Integer id, Model model)
            throws StudentNotFoundException {
        Student s = studentService.findById(id)
                .orElseThrow(() -> new StudentNotFoundException());
        model.addAttribute("student", s);
        if(s != null) {
            Registration r = registrationService.findByStudentId(s.getId());
            if(r != null) {
                model.addAttribute("registration", r);
            }
        }
        return "student/view";
    }

    @GetMapping(path="/all")
    public @ResponseBody
    Iterable<Student> getAllStudents() {
        return studentService.findAll();
    }

    @GetMapping(path="/search")
    public String searchStudent (@RequestParam(value = "search", required = false) String q, Model model)
            throws ClassNotFoundException {
        Iterable<Student> students = studentService.findByNameOrForenameContaining(q, q);
        model.addAttribute("students", students);
        return "student/result";
    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute Student s) {
        studentService.save(s);
        return "redirect:dashboard";
    }

    @GetMapping(path="/{id}/edit")
    public String viewUpdateFormStudent(@PathVariable(value = "id") Integer id,
                                        Model model) throws StudentNotFoundException {
        Student s = studentService.findById(id)
                .orElseThrow(() -> new StudentNotFoundException());
        model.addAttribute("student", s);
        return "student/edit";
    }

    @PutMapping("/{id}/update")
    public String updateStudent(@ModelAttribute Student s) {
        studentService.save(s);
        return "redirect:/student/dashboard";
    }

    @DeleteMapping("/delete")
    public String deleteStudent(@ModelAttribute Student s) {
        studentService.delete(s);
        return "redirect:dashboard";
    }
}