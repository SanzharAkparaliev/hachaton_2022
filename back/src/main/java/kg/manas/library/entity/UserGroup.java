package kg.manas.library.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "USER_GROUPS")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_GROUP_SEQ")
    @SequenceGenerator(name = "USER_GROUP_SEQ", sequenceName = "USER_GROUP_SEQ", allocationSize = 1)
    @Column(
            name = "USER_GROUP_ID",
            updatable = false
    )
    Long id;

    @Column(
            name = "USER_GROUP_NAME"
    )
    String name;

    @Column(
            name = "USER_GROUP_DESCRIPTION"
    )
    String description;
}
