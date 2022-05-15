package finki.projects.schoolmanagementsystem181074.web.controller;

import finki.projects.schoolmanagementsystem181074.model.School;
import finki.projects.schoolmanagementsystem181074.model.exceptions.SchoolNotFoundException;
import finki.projects.schoolmanagementsystem181074.service.SchoolService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/school")
public class SchoolController {

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping("/dashboard")
    public String schoolIndex(Model model) {
        model.addAttribute("school", new School());
        model.addAttribute("schools", schoolService.findAll());
        return "school/dashboard";
    }

    @GetMapping(path="/{id}")
    public @ResponseBody
    School getSchool (@PathVariable(value = "id") Integer id)
            throws SchoolNotFoundException {
        School s = schoolService.findById(id)
                .orElseThrow(() -> new SchoolNotFoundException(id));
        return s;
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<School> getAllSchools() {
        return schoolService.findAll();
    }

    @PostMapping("/create")
    public String createSchool(@ModelAttribute School s) {
        schoolService.save(s);
        return "redirect:dashboard";
    }

    @GetMapping(path="/{id}/edit")
    public String viewUpdateFormSchool(@PathVariable(value = "id") Integer id,
                                       Model model) throws SchoolNotFoundException {
        model.addAttribute("school", this.getSchool(id));
        return "school/edit";
    }

    @PutMapping("/{id}/update")
    public String updateSchool(@ModelAttribute School s) {
        schoolService.save(s);
        return "redirect:/school/dashboard";
    }

    @DeleteMapping("/delete")
    public String deleteSchool(@ModelAttribute School s) {
        schoolService.delete(s);
        return "redirect:dashboard";
    }
}