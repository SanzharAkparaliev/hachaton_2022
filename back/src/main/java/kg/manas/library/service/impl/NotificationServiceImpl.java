package kg.manas.library.service.impl;

import kg.manas.library.entity.BookCategory;
import kg.manas.library.entity.Notification;
import kg.manas.library.model.NotificationModel;
import kg.manas.library.repository.NotificationRepository;
import kg.manas.library.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class NotificationServiceImpl implements NotificationService {


    private NotificationRepository notificationRepository;

    @Override
    public NotificationModel get(Long id) {
        return notificationRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Notification  by id " + id + "cannot be found !"))
                .toModel();
    }

    @Override
    public NotificationModel save(NotificationModel notificationModel) {

        Notification notification = notificationModel.getId() == null ? new Notification() : notificationRepository.getById(notificationModel.getId());
        notification.setTitle(notificationModel.getTitle());
        notification.setMessage(notification.getMessage());
        notification.setRole(notification.getRole());
        notification.setExpiredDate(notificationModel.getExpiredDate());
        notification.setUserGroupId(notification.getUserGroupId());
        return notificationRepository.save(notification).toModel();

    }

    @Override
    public List<NotificationModel> getAll() {
        return notificationRepository.findAll().stream().map(Notification::toModel).collect(Collectors.toList());
    }
}
