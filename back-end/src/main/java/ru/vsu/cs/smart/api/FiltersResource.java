package ru.vsu.cs.smart.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.assertj.core.util.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.vsu.cs.smart.api.data.FiltersData;
import ru.vsu.cs.smart.common.exception.ResourceNotFoundException;
import ru.vsu.cs.smart.db.model.Filters;
import ru.vsu.cs.smart.db.model.User;
import ru.vsu.cs.smart.db.service.FiltersService;
import ru.vsu.cs.smart.db.service.UserService;
import ru.vsu.cs.smart.processing.Category;

import java.util.ArrayList;
import java.util.List;

@Api(
        value = "/filters",
        produces = "application/json",
        consumes = "application/json",
        description = "Сохранённые фильтры поиска"
)
@RestController
@RequestMapping("/filters")
public class FiltersResource {
    private final FiltersService filtersService;
    private final UserService userService;

    @Autowired
    public FiltersResource(FiltersService filtersService, UserService userService) {
        this.filtersService = filtersService;
        this.userService = userService;
    }

    @ApiOperation(
            value = "Получает все сохранённые фильтры пользователя",
            httpMethod = "GET",
            response = Filters.class,
            responseContainer = "List",
            notes = "Требуется указать существующий ID пользователя, например: 1\n" +
                    "В случае указания несуществующего ID пользователя, вернёт пустой массив."
    )
    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<FiltersData> findByCurrentUser(@ApiParam(value = "ID пользователя", required = true)
                                               @PathVariable("userId") Long userId) {
        Preconditions.checkNotNull(userId);
        List<FiltersData> response = new ArrayList<>();
        filtersService.findAllByCurrentUser(userId).forEach(
                filters -> response.add(new FiltersData(filters))
        );
        return response;
    }

    @ApiOperation(
            value = "Сохраняет фильтры",
            httpMethod = "POST",
            response = Filters.class,
            notes = "Требуется в теле запроса указать ID существующего пользователя, например: 1\n" +
                    "При указании поля category, его значение должно быть в диапазоне" +
                    " возможных категорий (см. /stores/categories)"
    )
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Filters save(@ApiParam(value = "Фильтры для сохранения", required = true)
                            @RequestBody FiltersData filtersData) {
        Preconditions.checkNotNull(filtersData);
        Preconditions.checkNotNull(filtersData.getUserId(), "User ID must be specified");
        Preconditions.checkArgument(
                filtersData.getCategory() == null
                        || Category.asStringSet().contains(filtersData.getCategory().toLowerCase()),
                "Invalid category"
        );
        User user = userService.find(filtersData.getUserId());
        Preconditions.checkArgument(
                userService.existsById(filtersData.getUserId()),
                "User with id '" + filtersData.getUserId() + "' not found"
        );
        return filtersService.save(filtersData.toFilters());
    }

    @ApiOperation(
            value = "Удаляет сохранённые фильтры",
            httpMethod = "DELETE"
    )
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@ApiParam(value = "ID сохранённыч фильтров", required = true)
                         @PathVariable("id") Long id) throws ResourceNotFoundException {
        Preconditions.checkNotNull(id);
        try {
            filtersService.delete(id);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Filters not found");
        }
    }
}
