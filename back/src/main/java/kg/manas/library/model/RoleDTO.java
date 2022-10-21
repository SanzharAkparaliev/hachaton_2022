package kg.manas.library.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoleDTO {

    Long id;
    String roleName;
    Set<PermissionDTO> permissions;
}
