package finki.projects.schoolmanagementsystem181074.exceptions;

public class TeacherNotFoundException extends Exception {
    public TeacherNotFoundException(String message){
        super(String.format("%s",message));
    }
}
