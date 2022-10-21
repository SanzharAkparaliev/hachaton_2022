package kg.manas.library.entity;

import kg.manas.library.model.NotificationModel;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "NOTIFICATION")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NOTIFICATION_SEQ")
    @SequenceGenerator(name = "NOTIFICATION_SEQ", sequenceName = "NOTIFICATION_SEQ", allocationSize = 1)
    Long id;

    String title;
    String message;

    @ManyToOne
    @JoinColumn(name = "role_id")
    Role role;

    @ManyToOne
    @JoinColumn(name = "user_group_id")
    UserGroup userGroupId;

    LocalDateTime expiredDate;

    NotificationModel toModel(){
        return NotificationModel.builder()
                .id(id)
                .title(title)
                .message(message)
                .roleId(role)
                .expiredDate(expiredDate)
                .userGroupId(userGroupId)
                .build();
    }
}
