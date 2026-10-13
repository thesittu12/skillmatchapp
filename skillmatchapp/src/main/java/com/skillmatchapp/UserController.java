package com.skillmatchapp;

import com.skillmatchapp.entity.User;
import com.skillmatchapp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody User loginData) {
        Optional<User> userOpt = userRepository.findAll().stream()
                .filter(u -> u.getEmail().equals(loginData.getEmail()) && u.getPassword().equals(loginData.getPassword()))
                .findFirst();
        return userOpt.orElse(null);
    }

    @PutMapping("/student/{id}/skills")
    public User updateSkills(@PathVariable Long id, @RequestBody User skillData) {
        Optional<User> userOpt = userRepository.findById(id);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            user.setSkills(skillData.getSkills());
            return userRepository.save(user);
        }
        return null;
    }
}