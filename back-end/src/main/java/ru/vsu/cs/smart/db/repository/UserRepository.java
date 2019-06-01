package ru.vsu.cs.smart.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vsu.cs.smart.db.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
