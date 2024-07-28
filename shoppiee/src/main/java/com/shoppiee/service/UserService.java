package com.shoppiee.service;

import com.shoppiee.model.User;
import com.shoppiee.repos.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User authenticateUser(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    public void createUser(User user) {
        userRepository.save(user);
    }

    public String getUserType(String username) {
        User user = userRepository.findByUsername(username);
        return user != null ? user.getPosition() : "";
    }

    public void removeEmployee(String username) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            userRepository.delete(user);
        }
    }
}
