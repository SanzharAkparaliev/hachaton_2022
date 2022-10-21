package kg.manas.library.service.impl;


import kg.manas.library.entity.Permission;
import kg.manas.library.model.PermissionDTO;
import kg.manas.library.model.RequestNewPermission;
import kg.manas.library.repository.PermissionRepository;
import kg.manas.library.service.PermissionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService {


    private final PermissionRepository permissionRepository;


    @Override
    public ResponseEntity<?> register(RequestNewPermission permission) {
        Permission newPermission = new Permission();
        newPermission.setPermissionName(permission.getPermissionName());
        permissionRepository.save(newPermission);
        return ResponseEntity.ok().build();
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
    public ResponseEntity<?> getPermission(Long id) {
        return permissionRepository.findById(id).map(permission -> {
            PermissionDTO permissionDTO = new PermissionDTO(id, permission.getPermissionName());
            return ResponseEntity.ok(permissionDTO);
        }).orElseGet(() -> {
            log.error("permission was not found");
            return ResponseEntity.unprocessableEntity().build();
        });


    }

    @Override
    @Transactional(propagation=Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
    public ResponseEntity<?> getAllPermissions() {
        List<PermissionDTO> responsePermissions = new ArrayList<>();
        List<Permission> permissions;
        PermissionDTO responsePermission;
        if (permissionRepository.findAllByRdtIsNull().isPresent()) {
            permissions = permissionRepository.findAllByRdtIsNull().get();
            for (Permission permission : permissions) {
                responsePermission = new PermissionDTO();
                responsePermission.setId(permission.getId());
                responsePermission.setPermissionName(permission.getPermissionName());
                responsePermissions.add(responsePermission);
            }
            return ResponseEntity.ok(responsePermissions);
        } else {
            log.error("there are no permissions");
            return ResponseEntity.unprocessableEntity().build();
        }

    }

    @Override
    public ResponseEntity<?> deletePermission(Long id) {
        return permissionRepository.findById(id).map(permission -> {
            permission.markRemoved();
            permissionRepository.save(permission);
            return ResponseEntity.ok().build();
        }).orElseGet(() -> {
            log.error("permission was not found");
            return ResponseEntity.unprocessableEntity().build();
        });
    }

    @Override
    public ResponseEntity<?> update(Long id, RequestNewPermission updatedPermission) {
        return permissionRepository.findByIdAndRdtIsNull(id).map(permission -> {
            permission.setPermissionName(updatedPermission.getPermissionName());
            permissionRepository.save(permission);
            return ResponseEntity.ok().build();
        }).orElseGet(() -> {
            log.error("permission was not found");
            return ResponseEntity.unprocessableEntity().build();
        });
    }
}
