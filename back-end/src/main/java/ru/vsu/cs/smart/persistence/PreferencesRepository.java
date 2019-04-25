package ru.vsu.cs.smart.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vsu.cs.smart.model.Preferences;

public interface PreferencesRepository extends JpaRepository<Preferences, Long> {
}
