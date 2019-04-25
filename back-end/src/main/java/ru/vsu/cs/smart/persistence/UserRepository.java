package ru.vsu.cs.smart.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vsu.cs.smart.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
