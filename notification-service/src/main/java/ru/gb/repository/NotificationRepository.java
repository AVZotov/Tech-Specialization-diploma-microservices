package ru.gb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.domain.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {
}
