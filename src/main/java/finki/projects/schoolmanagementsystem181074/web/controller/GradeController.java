package finki.projects.schoolmanagementsystem181074.web.controller;

import finki.projects.schoolmanagementsystem181074.model.Grade;
import finki.projects.schoolmanagementsystem181074.model.exceptions.GradeNotFoundException;
import finki.projects.schoolmanagementsystem181074.service.GradeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/grade")
public class GradeController {

    private final GradeService gradeService;

    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @GetMapping("/dashboard")
    public String gradeIndex(Model model) {
        model.addAttribute("grade", new Grade());
        model.addAttribute("grades", gradeService.findAll());
        return "grade/dashboard";
    }

    @GetMapping(path="/{id}")
    public @ResponseBody
    Grade getGrade (@PathVariable(value = "id") Integer id)
            throws GradeNotFoundException {
        Grade s = gradeService.findById(id)
                .orElseThrow(() -> new GradeNotFoundException());
        return s;
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Grade> getAllGrades() {
        return gradeService.findAll();
    }

    @PostMapping("/create")
    public String createGrade(@ModelAttribute Grade s) {
        gradeService.save(s);
        return "redirect:/grade/dashboard";
    }

    @GetMapping(path="/{id}/edit")
    public String viewUpdateFormGrade(@PathVariable(value = "id") Integer id,
                                      Model model) throws GradeNotFoundException {
        model.addAttribute("grade", this.getGrade(id));
        return "grade/edit";
    }

    @PutMapping("/{id}/update")
    public String updateGrade(@ModelAttribute Grade s) {
        gradeService.save(s);
        return "redirect:/grade/dashboard";
    }

    @DeleteMapping("/delete")
    public String deleteGrade(@ModelAttribute Grade s) {
        gradeService.delete(s);
        return "redirect:/grade/dashboard";
    }
}