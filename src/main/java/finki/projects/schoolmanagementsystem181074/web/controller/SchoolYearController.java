package finki.projects.schoolmanagementsystem181074.web.controller;

import finki.projects.schoolmanagementsystem181074.model.SchoolYear;
import finki.projects.schoolmanagementsystem181074.model.exceptions.SchoolYearNotFoundException;
import finki.projects.schoolmanagementsystem181074.service.SchoolYearService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "school_year")
public class SchoolYearController {

    private final SchoolYearService schoolYearService;

    @GetMapping("/dashboard")
    public String schoolYearIndex(Model model) {
        model.addAttribute("schoolYear", new SchoolYear());
        model.addAttribute("schoolYears", schoolYearService.findAll());
        return "school_year/dashboard";
    }

    @GetMapping(path="/{id}")
    public @ResponseBody
    SchoolYear getSchoolYear (@PathVariable(value = "id") Integer id)
            throws SchoolYearNotFoundException {
        SchoolYear s = schoolYearService.findById(id)
                .orElseThrow(() -> new SchoolYearNotFoundException());
        return s;
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<SchoolYear> getAllSchoolYears() {
        return schoolYearService.findAll();
    }

    @PostMapping("/create")
    public String createSchoolYear(@ModelAttribute SchoolYear s) {
        if(!schoolYearService.existsById(s.getId()))
            schoolYearService.save(s);
        return "redirect:dashboard";
    }

    @DeleteMapping("/delete")
    public String deleteSchoolYear(@ModelAttribute SchoolYear s) {
        schoolYearService.delete(s);
        return "redirect:dashboard";
    }
}}
