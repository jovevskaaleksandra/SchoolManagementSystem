package finki.projects.schoolmanagementsystem181074.service;

import finki.projects.schoolmanagementsystem181074.exceptions.ProjectAlreadyExists;
import finki.projects.schoolmanagementsystem181074.exceptions.ProjectNotFound;
import finki.projects.schoolmanagementsystem181074.model.Project;

import java.util.List;

public interface ProjectService {

    Project createProject(Project project) throws ProjectAlreadyExists;

    List<Project> listAllProjects();

    Project findProjectById(Long id) throws ProjectNotFound;

    void deleteProjectById(Long id) throws ProjectNotFound;
}
