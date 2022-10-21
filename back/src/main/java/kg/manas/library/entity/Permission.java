package kg.manas.library.entity;

import kg.manas.library.model.PermissionDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "PERMISSIONS")
@SequenceGenerator(name = "SEQ_ID", sequenceName = "USER_PERMISSION_SEQ", allocationSize = 1, initialValue = 10)
public class Permission extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_PERMISSION_SEQ")
    private Long id;

    @Column(name = "permission_name")
    private String permissionName;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.MERGE, mappedBy = "permissions")
    private Set<Role> roles;

    public PermissionDTO toModel() {
        return PermissionDTO.builder()
                .id(id)
                .permissionName(permissionName)
                .build();
    }


}
