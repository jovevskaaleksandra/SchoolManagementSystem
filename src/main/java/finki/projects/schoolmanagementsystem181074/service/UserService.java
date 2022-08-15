package finki.projects.schoolmanagementsystem181074.service;

import finki.projects.schoolmanagementsystem181074.enumerations.Role;
import finki.projects.schoolmanagementsystem181074.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User register(String username, String password, String repeatPassword, String name, String surname, Role role);
}
