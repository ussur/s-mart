package ru.vsu.cs.smart.api;

import org.assertj.core.util.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.vsu.cs.smart.db.model.Favourite;
import ru.vsu.cs.smart.db.service.FavouriteService;

import java.util.List;

@RestController
public class FavouriteResource {
    private final FavouriteService favouriteService;

    @Autowired
    public FavouriteResource(FavouriteService favouriteService) {
        this.favouriteService = favouriteService;
    }

    @GetMapping("/favourites/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Favourite> findByCurrentUser(@PathVariable("userId") Long userId) {
        Preconditions.checkNotNull(userId);
        return favouriteService.findAllByCurrentUser(userId);
    }

    @PostMapping("/favourites")
    @ResponseStatus(HttpStatus.OK)
    public Favourite save(@RequestBody Favourite favourite) {
        Preconditions.checkNotNull(favourite);
        return favouriteService.save(favourite);
    }

    @DeleteMapping("/favourites/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void save(@PathVariable("id") Long id) {
        Preconditions.checkNotNull(id);
        favouriteService.delete(id);
    }
}
