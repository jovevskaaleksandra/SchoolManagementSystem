package finki.projects.schoolmanagementsystem181074.exceptions;

public class TeacherAlreadyExistsException extends Exception {
    public TeacherAlreadyExistsException(String message){
        super(String.format("%s",message));
    }
}
