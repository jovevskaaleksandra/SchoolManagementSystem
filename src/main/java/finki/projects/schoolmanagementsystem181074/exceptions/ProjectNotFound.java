package finki.projects.schoolmanagementsystem181074.exceptions;

public class ProjectNotFound extends Exception {
    public ProjectNotFound(String message){
        super(String.format("%s",message));
    }
}
