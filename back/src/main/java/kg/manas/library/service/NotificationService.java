package kg.manas.library.service;

import kg.manas.library.model.NotificationModel;
import kg.manas.library.model.PublisherModel;

import java.util.List;

public interface NotificationService {
    NotificationModel get(Long id);

    NotificationModel save(NotificationModel notificationModel);

    List<NotificationModel> getAll();
}
