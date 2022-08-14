package finki.projects.schoolmanagementsystem181074.web;

import finki.projects.schoolmanagementsystem181074.exceptions.CourseAlreadyExists;
import finki.projects.schoolmanagementsystem181074.exceptions.ProjectAlreadyExists;
import finki.projects.schoolmanagementsystem181074.model.Course;
import finki.projects.schoolmanagementsystem181074.model.Project;
import finki.projects.schoolmanagementsystem181074.model.Teacher;
import finki.projects.schoolmanagementsystem181074.service.ProjectService;
import finki.projects.schoolmanagementsystem181074.service.TeacherService;
import finki.projects.schoolmanagementsystem181074.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        System.out.println(projects);
        model.addAttribute("projects", projects);
        return "projects";
    }

    @GetMapping("/add-project-form")
    public String showAdd(Model model){
        List<Teacher> teachers = this.teacherService.listAllTeachers();
        model.addAttribute("teachers", teachers);
        return "add-project";
    }

    @PostMapping
    public String create(@ModelAttribute("project") @RequestBody Project project, Model model) throws  ProjectAlreadyExists {
        this.projectService.createProject(project);
        model.addAttribute("teacher", "");
        return "redirect:/course";
    }
}
