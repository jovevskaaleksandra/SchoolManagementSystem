package finki.projects.schoolmanagementsystem181074.exceptions;

public class StudentAlreadyExistsException extends Exception{
    public StudentAlreadyExistsException(String message){
        super(String.format("%s",message));
    }
}
