package com.finanace.app.controller;

import com.finanace.app.model.Role;
import com.finanace.app.model.User;
import com.finanace.app.service.UserService;
import com.finanace.app.security.RoleChecker;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public User createUser(@RequestBody User user,
                           @RequestHeader Role role) {
        RoleChecker.checkAdmin(role);
        return service.createUser(user);
    }

    @GetMapping
    public List<User> getUsers(@RequestHeader Role role) {
        return service.getAllUsers();
    }
}