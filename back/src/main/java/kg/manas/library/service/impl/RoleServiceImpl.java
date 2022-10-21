package kg.manas.library.service.impl;


import kg.manas.library.entity.Permission;
import kg.manas.library.entity.Role;
import kg.manas.library.model.PermissionDTO;
import kg.manas.library.model.RequestNewRole;
import kg.manas.library.model.RoleDTO;
import kg.manas.library.repository.PermissionRepository;
import kg.manas.library.repository.RoleRepository;
import kg.manas.library.service.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;


    @Override
    public ResponseEntity<?> register(RequestNewRole role) {
        Role newRole = new Role();
        List<Long> permissions = role.getPermissions();
        Set<Permission> permissionSet = new HashSet<>();

        for (Long permission : permissions) {
            if (permissionRepository.findById(permission).isEmpty()) {
                log.error("permission by id :" + permission + "was not found");
                return ResponseEntity.unprocessableEntity().build();
            } else {
                permissionSet.add(permissionRepository.findById(permission).get());
            }
        }
        newRole.setRoleName(role.getRoleName());
        newRole.setPermissions(permissionSet);
        newRole = roleRepository.save(newRole);
        return ResponseEntity.ok().build();
    }

    @Transactional(propagation=Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
    @Override
    public ResponseEntity<?> getRole(Long id) {
        return roleRepository.findById(id).map(role -> {
            Set<Permission> permissions = role.getPermissions();
            Set<PermissionDTO> permissionsDTO = new HashSet<>();
            PermissionDTO permissionDTO;
            for (Permission permission : permissions) {
                permissionDTO = new PermissionDTO(permission.getId(), permission.getPermissionName());
                permissionsDTO.add(permissionDTO);
            }
            RoleDTO roleDto = new RoleDTO(id, role.getRoleName(),
                    permissionsDTO);
            return ResponseEntity.ok(roleDto);
        }).orElseGet(() -> {
            log.error("role was not found");
            return ResponseEntity.unprocessableEntity().build();
        });


    }

    @Transactional(propagation= Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
    @Override
    public ResponseEntity<?> getAllRoles() {
        List<RoleDTO> responseRoles = new ArrayList<>();
        List<Role> roles;
        RoleDTO responseRole;
        if (roleRepository.findAllByRdtIsNull().isPresent()) {
            roles = roleRepository.findAllByRdtIsNull().get();
            for (Role role : roles) {
                responseRole = new RoleDTO();
                responseRole.setId(role.getId());
                responseRole.setRoleName(role.getRoleName());
                Set<Permission> permissions = role.getPermissions();
                Set<PermissionDTO> permissionsDTO = new HashSet<>();
                PermissionDTO permissionDTO;
                for (Permission permission : permissions) {
                    permissionDTO = new PermissionDTO(permission.getId(), permission.getPermissionName());
                    permissionsDTO.add(permissionDTO);
                }
                responseRole.setPermissions(permissionsDTO);
                responseRoles.add(responseRole);
            }
            return ResponseEntity.ok(responseRoles);
        } else {
            log.error("there are no users");
            return ResponseEntity.unprocessableEntity().build();
        }

    }

    @Override
    public ResponseEntity<?> deleteRole(Long id) {
        return roleRepository.findById(id).map(role -> {
            role.markRemoved();
            roleRepository.save(role);
            return ResponseEntity.ok().build();
        }).orElseGet(() -> {
            log.error("role was not found");
            return ResponseEntity.unprocessableEntity().build();
        });
    }

    @Override
    public ResponseEntity<?> update(Long id, RequestNewRole updatedRole) {
        return roleRepository.findByIdAndRdtIsNull(id).map(role -> {
            List<Long> permissions = updatedRole.getPermissions();
            Set<Permission> permissionSet = new HashSet<>();
            for (Long permission : permissions) {
                if (permissionRepository.findById(permission).isEmpty()) {
                    log.error("permission by id :" + permission + "was not found");
                    return ResponseEntity.unprocessableEntity().build();
                } else {
                    permissionSet.add(permissionRepository.findById(permission).get());
                }
            }
            role.setRoleName(updatedRole.getRoleName());
            role.setPermissions(permissionSet);
            roleRepository.save(role);
            return ResponseEntity.ok().build();
        }).orElseGet(() -> {
            log.error("role was not found");
            return ResponseEntity.unprocessableEntity().build();
        });
    }
}
