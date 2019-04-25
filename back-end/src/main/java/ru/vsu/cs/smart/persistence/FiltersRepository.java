package ru.vsu.cs.smart.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vsu.cs.smart.model.Filters;

public interface FiltersRepository extends JpaRepository<Filters, Long> {
}
