package kg.manas.library.entity;


import kg.manas.library.model.UserNotificationModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserNotification {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_NOTIFICATION_SEQ")
    @SequenceGenerator(name = "USER_NOTIFICATION_SEQ", sequenceName = "USER_NOTIFICATION_SEQ", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "notification_id")
    private Notification notificationId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;
    boolean isViewed;

    public UserNotificationModel toModel(){
        return UserNotificationModel.builder()
                .id(id)
                .notificationId(notificationId)
                .userId(userId)
                .isViewed(isViewed)
                .build();
    }
}
