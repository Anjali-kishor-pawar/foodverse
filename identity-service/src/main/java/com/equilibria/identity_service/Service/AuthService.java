package com.equilibria.identity_service.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.equilibria.identity_service.Entity.UserCredential;
import com.equilibria.identity_service.Repository.UserCredentialRepository;

@Service
public class AuthService {

    @Autowired
    private UserCredentialRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService; 

    public String saveUser(UserCredential credential) {
        if (repository.existsByName(credential.getName())) {
            return "Username already exists.";
        }
    
        // Encode password before saving
        credential.setPassword(passwordEncoder.encode(credential.getPassword()));
    
        // Save the user credential to the repository
        repository.save(credential);
        return "User added to the system.";
    }

    public String generateToken(String username) {
        return jwtService.generateToken(username);
    }

    public void validateToken(String token) {
        jwtService.validateToken(token);
    }
 

}

