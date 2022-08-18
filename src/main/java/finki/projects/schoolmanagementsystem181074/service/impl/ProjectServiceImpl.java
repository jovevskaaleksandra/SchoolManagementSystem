package finki.projects.schoolmanagementsystem181074.service.impl;

import finki.projects.schoolmanagementsystem181074.exceptions.ProjectAlreadyExists;
import finki.projects.schoolmanagementsystem181074.exceptions.ProjectNotFound;
import finki.projects.schoolmanagementsystem181074.model.Project;
import finki.projects.schoolmanagementsystem181074.repository.ProjectRepository;
import finki.projects.schoolmanagementsystem181074.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project createProject(Project project) throws ProjectAlreadyExists {
        Optional<Project> existingProject = this.projectRepository.findByTitle(project.getTitle());
        if(existingProject.isPresent()){
            throw new ProjectAlreadyExists("Project already exists");
        }
        return projectRepository.save(project);
    }

    @Override
    public List<Project> listAllProjects() {
        return this.projectRepository.findAll();
    }

    @Override
    public Project findProjectById(Long id) throws ProjectNotFound {
        Optional<Project> project=this.projectRepository.findById(id);
        if(project.isEmpty()){
            throw new ProjectNotFound("Project not found");
        }
        return project.get();
    }

    @Override
    public void deleteProjectById(Long id) throws ProjectNotFound {
        Optional<Project> newProject = this.projectRepository.findById(id);
        if (newProject.isEmpty()){
            throw new ProjectNotFound("Project not found");
        }
        this.projectRepository.delete(newProject.get());
    }
}
