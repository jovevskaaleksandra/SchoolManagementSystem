package finki.projects.schoolmanagementsystem181074.web.controller;

import finki.projects.schoolmanagementsystem181074.model.Class1;
import finki.projects.schoolmanagementsystem181074.model.exceptions.LevelNotFoundException;
import finki.projects.schoolmanagementsystem181074.model.exceptions.RegistrationNotFoundException;
import finki.projects.schoolmanagementsystem181074.model.exceptions.SchoolNotFoundException;
import finki.projects.schoolmanagementsystem181074.model.exceptions.SchoolYearNotFoundException;
import finki.projects.schoolmanagementsystem181074.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path="/class")
public class ClassController {


        private final ClassService classService;

        private final SchoolYearService schoolYearService;

        private final SchoolService schoolService;

        private final LevelService levelService;

        private final RegistrationService registrationService;

        public ClassController(ClassService classService, SchoolYearService schoolYearService, SchoolService schoolService, LevelService levelService, RegistrationService registrationService) {
            this.classService = classService;
            this.schoolYearService = schoolYearService;
            this.schoolService = schoolService;
            this.levelService = levelService;
            this.registrationService = registrationService;
        }

        @GetMapping("/dashboard")
        public String classIndex(Model model) {
            model.addAttribute("class", new Class1());
            model.addAttribute("classes", classService.findAll());
            model.addAttribute("schools", schoolService.findAll());
            model.addAttribute("levels", levelService.findAll());
            model.addAttribute("schoolYears", schoolYearService.findAll());
            return "class/dashboard";
        }

        @GetMapping(path="/{id}")
        public String getClass (@PathVariable(value = "id") Integer id, Model model)
                throws ClassNotFoundException {
            Class1 s = classService.findById(id)
                    .orElseThrow(() -> new ClassNotFoundException());
            model.addAttribute("class", s);
            model.addAttribute("registrations", registrationService.findByCId(id));
            return "class/view";
        }

        @GetMapping(path="/all")
        public @ResponseBody
        List<Class1> getAllClasses() {
            return classService.findAll();
        }

        @GetMapping(path="/search")
        public String searchClass (@RequestParam(value = "search", required = false) String q, Model model)
                throws ClassNotFoundException {
            Iterable<Class1> classes = classService.findByNameContaining(q);
            model.addAttribute("classes", classes);
            return "class/result";
        }

        @PostMapping("/create")
        public String createClass(@ModelAttribute Class1 s) throws RegistrationNotFoundException, SchoolNotFoundException, SchoolYearNotFoundException, LevelNotFoundException {
            classService.save(s);
            return "redirect:dashboard";
        }

        @GetMapping(path="/{id}/edit")
        public String viewUpdateFormClass(@PathVariable(value = "id") Integer id,
                                          Model model) throws ClassNotFoundException {
            Class1 s = classService.findById(id)
                    .orElseThrow(() -> new ClassNotFoundException());
            model.addAttribute("class", s);
            model.addAttribute("schools", schoolService.findAll());
            model.addAttribute("levels", levelService.findAll());
            model.addAttribute("schoolYears", schoolYearService.findAll());
            return "class/edit";
        }

        @PutMapping("/{id}/update")
        public String updateClass(@ModelAttribute Class1 s) throws RegistrationNotFoundException, SchoolNotFoundException, SchoolYearNotFoundException, LevelNotFoundException {
            classService.save(s);
            return "redirect:/class/dashboard";
        }

        @DeleteMapping("/delete")
        public String deleteClass(@ModelAttribute Class1 s) {
            classService.delete(s);
            return "redirect:dashboard";
        }
}
