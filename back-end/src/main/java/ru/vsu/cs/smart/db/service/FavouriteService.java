package ru.vsu.cs.smart.db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vsu.cs.smart.db.model.Favourite;
import ru.vsu.cs.smart.db.repository.FavouriteRepository;

import java.util.List;

@Service
public class FavouriteService {
    @Autowired
    private FavouriteRepository favouriteRepository;

    public List<Favourite> findAllByCurrentUser(Long userId) {
        return favouriteRepository.findAllByCurrentUser(userId);
    }

    public Favourite save(Favourite favourite) {
        return favouriteRepository.save(favourite);
    }

    public void delete(Long id) {
        favouriteRepository.deleteById(id);
    }

    public void delete(Favourite favourite) {
        favouriteRepository.delete(favourite);
    }
}
