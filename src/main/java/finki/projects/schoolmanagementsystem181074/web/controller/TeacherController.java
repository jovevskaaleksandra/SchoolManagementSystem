package finki.projects.schoolmanagementsystem181074.web.controller;

import finki.projects.schoolmanagementsystem181074.model.Teacher;
import finki.projects.schoolmanagementsystem181074.model.exceptions.TeacherNotFoundException;
import finki.projects.schoolmanagementsystem181074.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/dashboard")
    public String teacherIndex(Model model) {
        model.addAttribute("teacher", new Teacher());
        model.addAttribute("teachers", teacherService.findAll());
        return "teacher/dashboard";
    }

    @GetMapping(path="/{id}")
    public @ResponseBody
    Teacher getTeacher (@PathVariable(value = "id") Integer id)
            throws TeacherNotFoundException {
        Teacher s = teacherService.findById(id)
                .orElseThrow(() -> new TeacherNotFoundException());
        return s;
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Teacher> getAllTeachers() {
        return teacherService.findAll();
    }

    @PostMapping("/create")
    public String createTeacher(@ModelAttribute Teacher s) {
        teacherService.save(s);
        return "redirect:dashboard";
    }

    @GetMapping(path="/{id}/edit")
    public String viewUpdateFormTeacher(@PathVariable(value = "id") Integer id,
                                        Model model) throws TeacherNotFoundException {
        model.addAttribute("teacher", this.getTeacher(id));
        return "teacher/edit";
    }

    @PutMapping("/{id}/update")
    public String updateTeacher(@ModelAttribute Teacher s) {
        teacherService.save(s);
        return "redirect:/teacher/dashboard";
    }

    @DeleteMapping("/delete")
    public String deleteTeacher(@ModelAttribute Teacher s) {
        teacherService.delete(s);
        return "redirect:dashboard";
    }
}}
