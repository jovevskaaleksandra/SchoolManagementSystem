package finki.projects.schoolmanagementsystem181074.exceptions;

public class StudentNotFoundException extends Exception{
    public StudentNotFoundException(String message){
        super(String.format("%s",message));
    }
}
