package finki.projects.schoolmanagementsystem181074.model.exceptions;

public class SchoolNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public SchoolNotFoundException() {
        super("School not found");
    }
}
