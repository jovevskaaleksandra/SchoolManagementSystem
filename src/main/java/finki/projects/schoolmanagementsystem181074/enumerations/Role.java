package finki.projects.schoolmanagementsystem181074.enumerations;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

    ROLE_TEACHER, ROLE_ADMIN, ROLE_STUDENT;

    @Override
    public String getAuthority() {
        return name();
    }
}
