package finki.projects.schoolmanagementsystem181074.service;

import finki.projects.schoolmanagementsystem181074.model.User;

public interface AuthService {
    User login(String username, String password);
}

