package ru.vsu.cs.smart.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vsu.cs.smart.model.Favourite;

public interface FavouriteRepository extends JpaRepository<Favourite, Long> {
}
