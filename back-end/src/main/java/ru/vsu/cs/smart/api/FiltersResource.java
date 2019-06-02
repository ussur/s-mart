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
import ru.vsu.cs.smart.db.model.Filters;
import ru.vsu.cs.smart.db.service.FiltersService;

import java.util.List;

@RestController
public class FiltersResource {
    private final FiltersService filtersService;

    @Autowired
    public FiltersResource(FiltersService filtersService) {
        this.filtersService = filtersService;
    }

    @GetMapping("/filters/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Filters> findByCurrentUser(@PathVariable("userId") Long userId) {
        Preconditions.checkNotNull(userId);
        return filtersService.findAllByCurrentUser(userId);
    }

    @PostMapping("/filters")
    @ResponseStatus(HttpStatus.OK)
    public Filters save(@RequestBody Filters filters) {
        Preconditions.checkNotNull(filters);
        return filtersService.save(filters);
    }

    @DeleteMapping("/filters/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void save(@PathVariable("id") Long id) {
        Preconditions.checkNotNull(id);
        filtersService.delete(id);
    }
}
