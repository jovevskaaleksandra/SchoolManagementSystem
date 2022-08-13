package finki.projects.schoolmanagementsystem181074.exceptions;

public class StudentAlreadyInCourseException extends Exception {
    public StudentAlreadyInCourseException(String message){
        super(String.format("%s",message));
    }
}
