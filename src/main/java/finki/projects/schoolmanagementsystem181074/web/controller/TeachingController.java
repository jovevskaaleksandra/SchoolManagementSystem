package finki.projects.schoolmanagementsystem181074.web.controller;

import finki.projects.schoolmanagementsystem181074.model.Teaching;
import finki.projects.schoolmanagementsystem181074.model.exceptions.SubjectNotFoundException;
import finki.projects.schoolmanagementsystem181074.model.exceptions.TeacherNotFoundException;
import finki.projects.schoolmanagementsystem181074.model.exceptions.TeachingNotFoundException;
import finki.projects.schoolmanagementsystem181074.service.ClassService;
import finki.projects.schoolmanagementsystem181074.service.SubjectService;
import finki.projects.schoolmanagementsystem181074.service.TeacherService;
import finki.projects.schoolmanagementsystem181074.service.TeachingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/teaching")
public class TeachingController {

    private final TeachingService teachingService;

    private final SubjectService subjectService;

    private final TeacherService teacherService;

    private final ClassService classService;

    public TeachingController(TeachingService teachingService, SubjectService subjectService, TeacherService teacherService, ClassService classService) {
        this.teachingService = teachingService;
        this.subjectService = subjectService;
        this.teacherService = teacherService;
        this.classService = classService;
    }

    @GetMapping("/dashboard")
    public String teachingIndex(Model model) {
        model.addAttribute("teaching", new Teaching());
        model.addAttribute("teachings", teachingService.findAll());
        model.addAttribute("classes", classService.findAll());
        model.addAttribute("teachers", teacherService.findAll());
        model.addAttribute("subjects", subjectService.findAll());
        return "teaching/dashboard";
    }

    @GetMapping(path="/{id}")
    public @ResponseBody
    Teaching getTeaching (@PathVariable(value = "id") Integer id)
            throws TeachingNotFoundException {
        Teaching s = teachingService.findById(id)
                .orElseThrow(() -> new TeachingNotFoundException());
        return s;
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Teaching> getAllTeachings() {
        return teachingService.findAll();
    }

    @PostMapping("/create")
    public String createTeaching(@ModelAttribute Teaching s) throws SubjectNotFoundException, TeacherNotFoundException, TeachingNotFoundException {
        teachingService.save(s);
        return "redirect:dashboard";
    }

    @GetMapping(path="/{id}/edit")
    public String viewUpdateFormTeaching(@PathVariable(value = "id") Integer id,
                                         Model model) throws TeachingNotFoundException {
        model.addAttribute("teaching", this.getTeaching(id));
        model.addAttribute("teachings", teachingService.findAll());
        model.addAttribute("classes", classService.findAll());
        model.addAttribute("teachers", teacherService.findAll());
        model.addAttribute("subjects", subjectService.findAll());
        return "teaching/edit";
    }

    @PutMapping("/{id}/update")
    public String updateTeaching(@ModelAttribute Teaching s) throws SubjectNotFoundException, TeacherNotFoundException, TeachingNotFoundException {
        teachingService.save(s);
        return "redirect:/teaching/dashboard";
    }

    @DeleteMapping("/delete")
    public String deleteTeaching(@ModelAttribute Teaching s) {
        teachingService.delete(s);
        return "redirect:dashboard";
    }
}
