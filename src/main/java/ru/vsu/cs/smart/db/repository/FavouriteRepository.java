package ru.vsu.cs.smart.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.vsu.cs.smart.db.model.Favourite;

import java.util.List;

public interface FavouriteRepository extends JpaRepository<Favourite, Long> {
    @Query("FROM Favourite f where f.user.id = :userId")
    List<Favourite> findAllByCurrentUser(@Param("userId") Long userId);
}
