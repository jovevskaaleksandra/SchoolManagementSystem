package finki.projects.schoolmanagementsystem181074.exceptions;

public class StudentDoesNotExistException extends Exception{
    public StudentDoesNotExistException(String message){
        super(String.format("%s",message));
    }
}
