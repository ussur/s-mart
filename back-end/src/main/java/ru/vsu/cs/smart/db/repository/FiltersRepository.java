package ru.vsu.cs.smart.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.vsu.cs.smart.db.model.Filters;

import java.util.List;

public interface FiltersRepository extends JpaRepository<Filters, Long> {
    @Query("FROM Filters f where f.user.id = :userId")
    List<Filters> findAllByCurrentUser(@Param("userId") Long userId);
}
