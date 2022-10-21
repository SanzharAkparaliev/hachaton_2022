package kg.manas.library.repository;

import kg.manas.library.entity.UserNotification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserNotificationRepository extends JpaRepository<UserNotification,Long> {
}
