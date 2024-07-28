package com.shoppiee.controller;

import com.shoppiee.model.User;
import com.shoppiee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public boolean login(@RequestBody User user) {
        User authenticatedUser = userService.authenticateUser(user.getUsername(), user.getPassword());
        return authenticatedUser != null;
    }

    @GetMapping("/getUserType/{username}")
    public String getUserType(@PathVariable String username) {
        return userService.getUserType(username);
    }

    @PostMapping("/createAccount")
    public void createAccount(@RequestBody User user) {
        userService.createUser(user);
    }

    @PostMapping("/removeEmployee")
    public void removeEmployee(@RequestBody User user) {
        userService.removeEmployee(user.getUsername());
    }
}
