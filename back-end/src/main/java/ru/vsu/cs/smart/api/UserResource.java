package ru.vsu.cs.smart.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.assertj.core.util.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.vsu.cs.smart.db.model.User;
import ru.vsu.cs.smart.db.service.UserService;

import java.util.List;
import java.util.Objects;

@Api(
        value = "/users",
        produces = "application/json",
        consumes = "application/json",
        description = "Пользователи"
)
@RestController
@RequestMapping("/users")
public class UserResource {
    private final UserService userService;

    @Autowired
    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(
            value = "Возвращает всех зарегистрированных пользователей",
            httpMethod = "GET",
            response = User.class,
            responseContainer = "List"
    )
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAll() {
        return userService.findAll();
    }

    /*@ApiOperation(
            value = "Создаёт нового пользователя",
            httpMethod = "POST",
            response = User.class,
            notes = "Выбрасывает исключение, если пользователь с заданным username уже существует."
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@ApiParam(value = "Новый пользователь")
                           @RequestBody User user) {
        Preconditions.checkNotNull(user);
        if (userService.findByUsername(user.getUsername()) != null) {
            throw new IllegalArgumentException("User with username '" +
                    user.getUsername() + "' already exists");
        }
        return userService.save(user);
    }*/

    @ApiOperation(
            value = "Обновляет существующего пользователя",
            httpMethod = "PUT",
            response = User.class
    )
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User update(@ApiParam(value = "ID пользователя для обновления", required = true)
                           @PathVariable("id") Long id,
                       @ApiParam(value = "Пользователь для обновления", required = true)
                           @RequestBody User user) {
        Preconditions.checkNotNull(id);
        Preconditions.checkNotNull(user);
        Preconditions.checkArgument(Objects.equals(id, user.getId()),
                "Path id (value = %d) and user id (value = %d) must be equal",
                id, user.getId());
        return userService.save(user);
    }
}
