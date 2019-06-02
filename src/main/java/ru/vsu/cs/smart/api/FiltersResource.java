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
import ru.vsu.cs.smart.db.model.Filters;
import ru.vsu.cs.smart.db.service.FiltersService;

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

    @Autowired
    public FiltersResource(FiltersService filtersService) {
        this.filtersService = filtersService;
    }

    @ApiOperation(
            value = "Получает все сохранённые фильтры пользователя",
            httpMethod = "GET",
            response = Filters.class,
            responseContainer = "List",
            notes = "Требуется указать существующий ID пользователя, например: 1"
    )
    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Filters> findByCurrentUser(@ApiParam(value = "ID пользователя", required = true)
                                               @PathVariable("userId") Long userId) {
        Preconditions.checkNotNull(userId);
        return filtersService.findAllByCurrentUser(userId);
    }

    @ApiOperation(
            value = "Сохраняет фильтры",
            httpMethod = "POST",
            response = Filters.class,
            notes = "Требуется в теле запроса указать существующего пользователя, например:\n" +
            "{\"id\": \"1\", \"username\": \"alice\", \"password\": \"1\"}"
    )
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Filters save(@ApiParam(value = "Фильтры для сохранения")
                            @RequestBody Filters filters) {
        Preconditions.checkNotNull(filters);
        return filtersService.save(filters);
    }

    @ApiOperation(
            value = "Удаляет сохранённые фильтры",
            httpMethod = "DELETE"
    )
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void save(@ApiParam(value = "ID сохранённыч фильтров", required = true)
                         @PathVariable("id") Long id) {
        Preconditions.checkNotNull(id);
        filtersService.delete(id);
    }
}
