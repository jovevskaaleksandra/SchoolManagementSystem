package finki.projects.schoolmanagementsystem181074.web.controller;

import finki.projects.schoolmanagementsystem181074.repository.*;
import finki.projects.schoolmanagementsystem181074.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/class")
public class ClassController {

    private final ClassService classService;

    private final SchoolYearService schoolYearService;

    private final SchoolService schoolService;

    private final LevelService levelService;

    private final RegistrationService registrationService;

    @GetMapping("/dashboard")
    public String classIndex(Model model) {
        model.addAttribute("class", new Class());
        model.addAttribute("classes", classService.findAll());
        model.addAttribute("schools", schoolService.findAll());
        model.addAttribute("levels", levelService.findAll());
        model.addAttribute("schoolYears", schoolYearService.findAll());
        return "class/dashboard";
    }

    @GetMapping(path="/{id}")
    public String getClass (@PathVariable(value = "id") Integer id, Model model)
            throws ClassNotFoundException {
        Class s = classService.findById(id)
                .orElseThrow(() -> new ClassNotFoundException());
        model.addAttribute("class", s);
        model.addAttribute("registrations", registrationService.findByCId(id));
        return "class/view";
    }

    @GetMapping(path="/all")
    public @ResponseBody
    Iterable<Class> getAllClasses() {
        return classService.findAll();
    }

    @GetMapping(path="/search")
    public String searchClass (@RequestParam(value = "search", required = false) String q, Model model)
            throws ClassNotFoundException {
        Iterable<Class> classes = classService.findByNameContaining(q);
        model.addAttribute("classes", classes);
        return "class/result";
    }

    @PostMapping("/create")
    public String createClass(@ModelAttribute Class s) {
        classService.save(s);
        return "redirect:dashboard";
    }

    @GetMapping(path="/{id}/edit")
    public String viewUpdateFormClass(@PathVariable(value = "id") Integer id,
                                      Model model) throws ClassNotFoundException {
        Class s = classService.findById(id)
                .orElseThrow(() -> new ClassNotFoundException());
        model.addAttribute("class", s);
        model.addAttribute("schools", schoolService.findAll());
        model.addAttribute("levels", levelService.findAll());
        model.addAttribute("schoolYears", schoolYearService.findAll());
        return "class/edit";
    }

    @PutMapping("/{id}/update")
    public String updateClass(@ModelAttribute Class s) {
        classService.save(s);
        return "redirect:/class/dashboard";
    }

    @DeleteMapping("/delete")
    public String deleteClass(@ModelAttribute Class s) {
        classService.delete(s);
        return "redirect:dashboard";
    }
}
