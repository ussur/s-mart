package ru.vsu.cs.smart.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vsu.cs.smart.model.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
