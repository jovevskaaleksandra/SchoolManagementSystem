package finki.projects.schoolmanagementsystem181074.exceptions;

public class ProjectAlreadyExists extends Exception {
    public ProjectAlreadyExists(String message){
        super(String.format("%s",message));
    }
}
