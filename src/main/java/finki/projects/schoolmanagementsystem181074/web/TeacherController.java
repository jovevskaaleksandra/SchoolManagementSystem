package finki.projects.schoolmanagementsystem181074.web;

import finki.projects.schoolmanagementsystem181074.exceptions.TeacherAlreadyExistsException;
import finki.projects.schoolmanagementsystem181074.exceptions.TeacherNotFoundException;
import finki.projects.schoolmanagementsystem181074.model.Course;
import finki.projects.schoolmanagementsystem181074.model.Teacher;
import finki.projects.schoolmanagementsystem181074.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public String findAll(Model model){
        List<Teacher> teachers = this.teacherService.listAllTeachers();
        model.addAttribute("teachers", teachers);
        return "teachers";
    }

    @GetMapping("/add-teacher-form")
    public String showAdd(Model model){
        List<Teacher> teachers = this.teacherService.listAllTeachers();
        model.addAttribute("teachers", teachers);
        return "add-teacher";
    }

    @PostMapping
    public String create(Teacher teacher) throws TeacherAlreadyExistsException{
        this.teacherService.createTeacher(teacher);
        return "redirect:/teacher";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) throws TeacherNotFoundException{
        this.teacherService.deleteTeacherById(id);
        return "redirect:/teacher";
    }

}
