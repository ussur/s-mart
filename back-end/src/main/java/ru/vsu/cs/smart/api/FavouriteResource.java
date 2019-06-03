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
import ru.vsu.cs.smart.api.responses.FavouriteResponse;
import ru.vsu.cs.smart.common.exception.ResourceNotFoundException;
import ru.vsu.cs.smart.db.model.Favourite;
import ru.vsu.cs.smart.db.service.FavouriteService;

import java.util.ArrayList;
import java.util.List;

@Api(
        value = "/favourites",
        produces = "application/json",
        consumes = "application/json",
        description = "Сохранённые товары"
)
@RestController
@RequestMapping("/favourites")
public class FavouriteResource {
    private final FavouriteService favouriteService;

    @Autowired
    public FavouriteResource(FavouriteService favouriteService) {
        this.favouriteService = favouriteService;
    }

    @ApiOperation(
            value = "Получает все сохранённые товары пользователя",
            httpMethod = "GET",
            response = Favourite.class,
            responseContainer = "List",
            notes = "Требуется указать существующий ID пользователя, например: 1\n" +
                    "В случае указания несуществующего ID пользователя, вернёт пустой массив."
    )
    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<FavouriteResponse> findByCurrentUser(@ApiParam(value = "ID пользователя", required = true)
                                                 @PathVariable("userId") Long userId) {
        Preconditions.checkNotNull(userId);
        List<FavouriteResponse> response = new ArrayList<>();
        favouriteService.findAllByCurrentUser(userId).forEach(
                favourite -> response.add(new FavouriteResponse(favourite))
        );
        return response;
    }

    @ApiOperation(
            value = "Сохраняет товар в закладки",
            httpMethod = "POST",
            response = Favourite.class,
            notes = "Требуется в теле запроса указать существующего пользователя, например:\n" +
                    "{\"id\": \"1\", \"username\": \"alice\", \"password\": \"1\"}"
    )
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Favourite save(@ApiParam(value = "Товар для сохранения")
                              @RequestBody Favourite favourite) {
        Preconditions.checkNotNull(favourite);
        return favouriteService.save(favourite);
    }

    @ApiOperation(
            value = "Удаляет сохранённый товар",
            httpMethod = "DELETE"
    )
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void save(@ApiParam(value = "ID сохранённого товара", required = true)
                         @PathVariable("id") Long id) {
        Preconditions.checkNotNull(id);
        try {
            favouriteService.delete(id);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Filters not found");
        }
    }
}
