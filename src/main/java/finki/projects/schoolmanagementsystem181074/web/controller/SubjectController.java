package finki.projects.schoolmanagementsystem181074.web.controller;

import finki.projects.schoolmanagementsystem181074.model.Subject;
import finki.projects.schoolmanagementsystem181074.model.exceptions.SubjectNotFoundException;
import finki.projects.schoolmanagementsystem181074.service.SubjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/subject")
public class SubjectController {

    private final SubjectService subjectService;

    @GetMapping("/dashboard")
    public String subjectIndex(Model model) {
        model.addAttribute("subject", new Subject());
        model.addAttribute("subjects", subjectService.findAll());
        return "subject/dashboard";
    }

    @GetMapping(path="/{id}")
    public @ResponseBody
    Subject getSubject (@PathVariable(value = "id") Integer id)
            throws SubjectNotFoundException {
        Subject s = subjectService.findById(id)
                .orElseThrow(() -> new SubjectNotFoundException());
        return s;
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Subject> getAllSubjects() {
        return subjectService.findAll();
    }

    @PostMapping("/create")
    public String createSubject(@ModelAttribute Subject s) {
        subjectService.save(s);
        return "redirect:dashboard";
    }

    @GetMapping(path="/{id}/edit")
    public String viewUpdateFormSubject(@PathVariable(value = "id") Integer id,
                                        Model model) throws SubjectNotFoundException {
        model.addAttribute("subject", this.getSubject(id));
        return "subject/edit";
    }

    @PutMapping("/{id}/update")
    public String updateSubject(@ModelAttribute Subject s) {
        subjectService.save(s);
        return "redirect:/subject/dashboard";
    }

    @DeleteMapping("/delete")
    public String deleteSubject(@ModelAttribute Subject s) {
        subjectService.delete(s);
        return "redirect:dashboard";
    }
}