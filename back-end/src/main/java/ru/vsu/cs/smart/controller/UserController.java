package ru.vsu.cs.smart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.vsu.cs.smart.model.User;
import ru.vsu.cs.smart.service.UserService;

import java.util.List;

@RestController("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<User> users = userService.getAll();
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody User user) {
        User savedUser = userService.save(user);
        return ResponseEntity.ok(savedUser);
    }
}
