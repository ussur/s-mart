package ru.vsu.cs.smart.auth.api;

import org.assertj.core.util.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.vsu.cs.smart.auth.requests.Credentials;
import ru.vsu.cs.smart.common.exception.ResourceNotFoundException;
import ru.vsu.cs.smart.db.model.User;
import ru.vsu.cs.smart.db.service.UserService;

import java.util.Objects;
import java.util.Optional;

@RestController
public class AuthResource {
    private final UserService userService;

    @Autowired
    public AuthResource(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/auth/login")
    @ResponseStatus(HttpStatus.OK)
    public User login(@RequestBody Credentials credentials) throws ResourceNotFoundException {
        Preconditions.checkNotNull(credentials);
        Optional<User> user = Optional.ofNullable(
                userService.findByUsername(credentials.getUsername()));
        if (!user.isPresent() || !Objects.equals(user.get().getPassword(),
                credentials.getPassword())) {
            throw new ResourceNotFoundException();
        }
        return user.get();
    }

    @PostMapping("/auth/logout")
    @ResponseStatus(HttpStatus.OK)
    public void logout(@RequestBody User user) {

    }

    @PostMapping("/auth/register")
    @ResponseStatus(HttpStatus.OK)
    public User register(@RequestBody Credentials credentials) {
        Preconditions.checkNotNull(credentials);
        User user = new User();
        user.setUsername(credentials.getUsername());
        user.setPassword(credentials.getPassword());
        return userService.save(user);
    }
}
