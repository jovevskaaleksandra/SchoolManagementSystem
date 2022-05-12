package finki.projects.schoolmanagementsystem181074.web.controller;

import finki.projects.schoolmanagementsystem181074.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/class")
public class ClassController {

    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private SchoolYearRepository schoolYearRepository;

    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private LevelRepository levelRepository;

    @Autowired
    private RegistrationRepository registrationRepository;

    @GetMapping("/dashboard")
    public String classIndex(Model model) {
        model.addAttribute("class", new Class());
        model.addAttribute("classes", classRepository.findAll());
        model.addAttribute("schools", schoolRepository.findAll());
        model.addAttribute("levels", levelRepository.findAll());
        model.addAttribute("schoolYears", schoolYearRepository.findAll());
        return "class/dashboard";
    }

    @GetMapping(path="/{id}")
    public String getClass (@PathVariable(value = "id") Integer id, Model model)
            throws ClassNotFoundException {
        Class s = classRepository.findById(id)
                .orElseThrow(() -> new ClassNotFoundException());
        model.addAttribute("class", s);
        model.addAttribute("registrations", registrationRepository.findByCId(id));
        return "class/view";
    }

    @GetMapping(path="/all")
    public @ResponseBody
    Iterable<Class> getAllClasses() {
        return classRepository.findAll();
    }

    @GetMapping(path="/search")
    public String searchClass (@RequestParam(value = "search", required = false) String q, Model model)
            throws ClassNotFoundException {
        Iterable<Class> classes = classRepository.findByNameContaining(q);
        model.addAttribute("classes", classes);
        return "class/result";
    }

    @PostMapping("/create")
    public String createClass(@ModelAttribute Class s) {
        classRepository.save(s);
        return "redirect:dashboard";
    }

    @GetMapping(path="/{id}/edit")
    public String viewUpdateFormClass(@PathVariable(value = "id") Integer id,
                                      Model model) throws ClassNotFoundException {
        Class s = classRepository.findById(id)
                .orElseThrow(() -> new ClassNotFoundException());
        model.addAttribute("class", s);
        model.addAttribute("schools", schoolRepository.findAll());
        model.addAttribute("levels", levelRepository.findAll());
        model.addAttribute("schoolYears", schoolYearRepository.findAll());
        return "class/edit";
    }

    @PutMapping("/{id}/update")
    public String updateClass(@ModelAttribute Class s) {
        classRepository.save(s);
        return "redirect:/class/dashboard";
    }

    @DeleteMapping("/delete")
    public String deleteClass(@ModelAttribute Class s) {
        classRepository.delete(s);
        return "redirect:dashboard";
    }
}
