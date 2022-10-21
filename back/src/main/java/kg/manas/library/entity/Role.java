package kg.manas.library.entity;


import kg.manas.library.model.RoleDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "ROLES")
@SequenceGenerator(name = "SEQ_ID", sequenceName = "ROLE_SEQ", allocationSize = 1, initialValue = 10)
public class Role extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROLE_SEQ")
    private Long id;

    @Column(name = "role_name")
    private String roleName;



    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinTable(name = "role_has_permissions",
            joinColumns = {@JoinColumn(name = "id_role")},
            inverseJoinColumns = {@JoinColumn(name = "id_permission")})
    private Set<Permission> permissions;

    @Transactional(propagation= Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
    public Set<Permission> getPermissions() {
        return permissions;
    }

    public RoleDTO toModel() {
        return RoleDTO.builder()
                .id(id)
                .roleName(roleName)
                .permissions(permissions.stream().map(Permission::toModel).collect(Collectors.toSet()))
                .build();
    }
}
