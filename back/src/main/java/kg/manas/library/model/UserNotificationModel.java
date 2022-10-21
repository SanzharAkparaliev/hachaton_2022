package kg.manas.library.model;

import kg.manas.library.entity.Notification;
import kg.manas.library.entity.User;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserNotificationModel {
     Long id;
     Notification notificationId;
     User userId;
     boolean isViewed;
}
