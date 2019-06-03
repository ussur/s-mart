package ru.vsu.cs.smart.auth.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.assertj.core.util.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.vsu.cs.smart.auth.requests.Credentials;
import ru.vsu.cs.smart.common.exception.ResourceNotFoundException;
import ru.vsu.cs.smart.db.model.User;
import ru.vsu.cs.smart.db.service.UserService;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Objects;
import java.util.Optional;

@Api(
        value = "/auth",
        produces = "application/json",
        consumes = "application/json",
        description = "Авторизация и регистрация"
)
@RestController
@RequestMapping("/auth")
public class AuthResource {
    private final UserService userService;

    @Autowired
    public AuthResource(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(
            value = "Авторизует пользователя",
            httpMethod = "POST",
            response = User.class,
            notes = "Зарегистрированные пользователи:\n" +
                    "{\"username\": \"alice\", \"password\": \"1\"} или\n" +
                    "{\"username\": \"bob\", \"password\": \"2\"}"
    )
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public User login(@ApiParam(value = "Имя пользователя и пароль для входа", required = true)
                          @RequestBody Credentials credentials) throws ResourceNotFoundException {
        Preconditions.checkNotNull(credentials);
        Optional<User> user = Optional.ofNullable(
                userService.findByUsername(credentials.getUsername()));
        if (!user.isPresent() || !Objects.equals(user.get().getPassword(),
                credentials.getPassword())) {
            throw new ResourceNotFoundException("Invalid username or password");
        }
        return user.get();
    }

    @ApiIgnore
    @ApiOperation(
            value = "Закрывает сессию пользователя",
            httpMethod = "POST"
    )
    @PostMapping("/logout")
    @ResponseStatus(HttpStatus.OK)
    public void logout(@ApiParam(value = "Пользователь, выходящий из приложения", required = true)
                           @RequestBody User user) {

    }

    @ApiOperation(
            value = "Регистрирует нового пользователя",
            httpMethod = "POST",
            response = User.class
    )
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public User register(@ApiParam(value = "Имя и пароль нового пользователя", required = true)
                             @RequestBody Credentials credentials) {
        Preconditions.checkNotNull(credentials);
        if (userService.findByUsername(credentials.getUsername()) != null) {
            throw new IllegalArgumentException("User with username '" +
                    credentials.getUsername() + "' already exists");
        }
        User user = new User();
        user.setUsername(credentials.getUsername());
        user.setPassword(credentials.getPassword());
        return userService.save(user);
    }
}
