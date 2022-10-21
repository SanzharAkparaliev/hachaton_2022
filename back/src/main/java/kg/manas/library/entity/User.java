package kg.manas.library.entity;

import kg.manas.library.model.RoleDTO;
import kg.manas.library.model.UserDTO;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import javax.validation.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "USERS")
@SequenceGenerator(name = "SEQ_ID", sequenceName = "USER_SEQ", allocationSize = 1)
public class User extends BaseEntity implements UserDetails, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ")
    private Long id;

    @NotBlank
    @Column(name = "USERNAME", unique = true)
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_role")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "USER_GROUP_ID")
    UserGroup userGroupId;

    @Override
    @Transactional(propagation= Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermissionName()))
                .collect(Collectors.toSet());
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public UserDTO toModel() {
        return UserDTO.builder()
                .id(id)
                .role(role == null ? new RoleDTO() : role.toModel())
                .username(username)
                .build();
    }
}
