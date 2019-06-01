package ru.vsu.cs.smart.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vsu.cs.smart.db.model.Favourite;

public interface FavouriteRepository extends JpaRepository<Favourite, Long> {
}
