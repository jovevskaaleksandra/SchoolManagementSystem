package finki.projects.schoolmanagementsystem181074.web.controller;

import finki.projects.schoolmanagementsystem181074.model.Registration;
import finki.projects.schoolmanagementsystem181074.model.exceptions.RegistrationNotFoundException;
import finki.projects.schoolmanagementsystem181074.model.exceptions.StudentNotFoundException;
import finki.projects.schoolmanagementsystem181074.service.ClassService;
import finki.projects.schoolmanagementsystem181074.service.RegistrationService;
import finki.projects.schoolmanagementsystem181074.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/registration")
public class RegistrationController {

    private final RegistrationService registrationService;

    private final ClassService classService;

    private final StudentService studentService;

    public RegistrationController(RegistrationService registrationService, ClassService classService, StudentService studentService) {
        this.registrationService = registrationService;
        this.classService = classService;
        this.studentService = studentService;
    }

    @GetMapping("/dashboard")
    public String registrationIndex(Model model) {
        model.addAttribute("registration", new Registration());
        model.addAttribute("registrations", registrationService.findAll());
        model.addAttribute("students", studentService.findAll());
        model.addAttribute("classes", classService.findAll());
        return "registration/dashboard";
    }

    @GetMapping(path="/{id}")
    public @ResponseBody
    Registration getRegistration (@PathVariable(value = "id") Integer id)
            throws RegistrationNotFoundException {
        Registration s = registrationService.findById(id)
                .orElseThrow(() -> new RegistrationNotFoundException());
        return s;
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Registration> getAllRegistrations() {
        return registrationService.findAll();
    }

    @PostMapping("/create")
    public String createRegistration(@ModelAttribute Registration s) throws StudentNotFoundException, ClassNotFoundException {
        if(registrationService.findByStudentId(s.getStudent().getId()) != null)
            System.out.println("Student already has a class.");
        else
            registrationService.save(s);
        return "redirect:dashboard";
    }

    @GetMapping(path="/{id}/edit")
    public String viewUpdateFormRegistration(@PathVariable(value = "id") Integer id,
                                             Model model) throws RegistrationNotFoundException {
        model.addAttribute("registration", this.getRegistration(id));
        model.addAttribute("students", studentService.findAll());
        model.addAttribute("classes", classService.findAll());
        return "registration/edit";
    }

    @PutMapping("/{id}/update")
    public String updateRegistration(@ModelAttribute Registration s) throws StudentNotFoundException, ClassNotFoundException {
        registrationService.save(s);
        return "redirect:/registration/dashboard";
    }

    @DeleteMapping("/delete")
    public String deleteRegistration(@ModelAttribute Registration s) {
        registrationService.delete(s);
        return "redirect:dashboard";
    }
}
