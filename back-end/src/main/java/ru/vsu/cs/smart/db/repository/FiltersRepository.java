package ru.vsu.cs.smart.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vsu.cs.smart.db.model.Filters;

public interface FiltersRepository extends JpaRepository<Filters, Long> {
}
