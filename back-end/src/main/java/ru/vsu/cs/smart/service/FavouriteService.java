package ru.vsu.cs.smart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vsu.cs.smart.model.Favourite;
import ru.vsu.cs.smart.persistence.FavouriteRepository;

@Service
public class FavouriteService {
    @Autowired
    private FavouriteRepository favouriteRepository;

    public Favourite save(Favourite favourite) {
        return favouriteRepository.save(favourite);
    }

    public void delete(Favourite favourite) {
        favouriteRepository.delete(favourite);
    }
}
