package finki.projects.schoolmanagementsystem181074.exceptions;

public class CourseNotFoundException extends Exception{
    public CourseNotFoundException(String message){
        super(String.format("%s",message));
    }
}
