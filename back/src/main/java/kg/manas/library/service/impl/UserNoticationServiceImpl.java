package kg.manas.library.service.impl;

import kg.manas.library.entity.UserNotification;
import kg.manas.library.model.UserNotificationModel;
import kg.manas.library.repository.UserNotificationRepository;
import kg.manas.library.service.UserNotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserNoticationServiceImpl implements UserNotificationService {
    private UserNotificationRepository userNotificationRepository;

    @Override
    public UserNotificationModel get(Long id) {
        return userNotificationRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User Notification: " + id + " cannot be found !"))
                .toModel();
    }

    @Override
    public UserNotificationModel save(UserNotificationModel userNotificationModel) {
        UserNotification userNotification = userNotificationModel.getId() == null ? new UserNotification() : userNotificationRepository.getById(userNotificationModel.getId());

        userNotification.setNotificationId(userNotificationModel.getNotificationId());
        userNotification.setViewed(userNotificationModel.isViewed());
        userNotification.setUserId(userNotificationModel.getUserId());
        return userNotificationRepository.save(userNotification).toModel();
    }

    @Override
    public List<UserNotificationModel> getAll() {
        return userNotificationRepository.findAll().stream()
                .map(UserNotification::toModel).collect(Collectors.toList());
    }
}
