package finki.projects.schoolmanagementsystem181074.web;

import finki.projects.schoolmanagementsystem181074.exceptions.ProjectAlreadyExists;
import finki.projects.schoolmanagementsystem181074.model.Project;
import finki.projects.schoolmanagementsystem181074.model.Teacher;
import finki.projects.schoolmanagementsystem181074.model.User;
import finki.projects.schoolmanagementsystem181074.service.ProjectService;
import finki.projects.schoolmanagementsystem181074.service.TeacherService;
import finki.projects.schoolmanagementsystem181074.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/project")
public class ProjectController {

    private final ProjectService projectService;
    private final TeacherService teacherService;
    private final UserService userService;


    public ProjectController(ProjectService projectService, TeacherService teacherService, UserService userService) {
        this.projectService = projectService;
        this.teacherService = teacherService;
        this.userService = userService;
    }
    @ModelAttribute("project")
    public Project project(){
        return new Project();
    }

    @GetMapping
    public String findAll(Model model){
        List<Project> projects = this.projectService.listAllProjects();
        model.addAttribute("projects", projects);

        return "projects";
    }

    @GetMapping("/add-project-form")
    public String showAdd(@RequestParam(required = false) String error,
                          HttpServletRequest req,
                          Model model){
        List<Teacher> teachers = this.teacherService.listAllTeachers();
        model.addAttribute("teachers", teachers);
        String username = req.getRemoteUser();
        UserDetails user= this.userService.loadUserByUsername(username);
        model.addAttribute("user", user);
        return "add-project";
    }

    @PostMapping
    public String create(HttpServletRequest req, Authentication authentication, @ModelAttribute("project") @RequestBody Project project, Model model) throws  ProjectAlreadyExists {

            User user = (User) authentication.getPrincipal();
            project.setUser(user);
            model.addAttribute("user",user);
            this.projectService.createProject(project);
            model.addAttribute("teacher", "");
            return "redirect:/project";
    }
}
