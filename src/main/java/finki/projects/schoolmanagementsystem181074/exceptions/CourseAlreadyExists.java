package finki.projects.schoolmanagementsystem181074.exceptions;

public class CourseAlreadyExists extends Exception{
    public CourseAlreadyExists(String message){
        super(String.format("%s",message));
    }
}
