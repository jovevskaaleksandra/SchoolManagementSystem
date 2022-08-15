package finki.projects.schoolmanagementsystem181074.service.impl;

import finki.projects.schoolmanagementsystem181074.exceptions.InvalidArgumentsException;
import finki.projects.schoolmanagementsystem181074.exceptions.InvalidUserCredentialsException;
import finki.projects.schoolmanagementsystem181074.model.User;
import finki.projects.schoolmanagementsystem181074.repository.UserRepository;
import finki.projects.schoolmanagementsystem181074.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) {
        if (username==null || username.isEmpty() || password==null || password.isEmpty()) {
            throw new InvalidArgumentsException();
        }
        return userRepository.findByUsernameAndPassword(username,
                password).orElseThrow(InvalidUserCredentialsException::new);
    }

}
