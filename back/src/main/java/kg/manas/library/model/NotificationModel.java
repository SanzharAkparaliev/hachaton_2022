package kg.manas.library.model;


import kg.manas.library.entity.Role;
import kg.manas.library.entity.User;
import kg.manas.library.entity.UserGroup;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NotificationModel {
    Long id;
    String title;
    String message;
    Role roleId;
    UserGroup userGroupId;
    LocalDateTime expiredDate;
}
