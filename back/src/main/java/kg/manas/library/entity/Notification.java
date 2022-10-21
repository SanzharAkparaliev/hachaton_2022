package kg.manas.library.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NOTIFICATION_SEQ")
    @SequenceGenerator(name = "NOTIFICATION_SEQ", sequenceName = "NOTIFICATION_SEQ", allocationSize = 1)
    private Long id;

    private String title;
    private String message;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @ManyToOne
    @JoinColumn(name = "user_group_id")
    private UserGroup userGroupId;

    private LocalDateTime expiredDate;
}
