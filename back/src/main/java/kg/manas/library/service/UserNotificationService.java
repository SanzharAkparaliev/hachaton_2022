package kg.manas.library.service;

import kg.manas.library.model.NotificationModel;
import kg.manas.library.model.UserNotificationModel;

import java.util.List;

public interface UserNotificationService {
    UserNotificationModel get(Long id);

    UserNotificationModel save(UserNotificationModel userNotificationModel);

    List<UserNotificationModel> getAll();
}
