package kg.manas.library.service;


import kg.manas.library.model.RequestNewPermission;
import org.springframework.http.ResponseEntity;

public interface PermissionService {

    ResponseEntity<?> register(RequestNewPermission permission);

    ResponseEntity<?> getPermission(Long id);

    ResponseEntity<?> getAllPermissions();

    ResponseEntity<?> deletePermission(Long id);

    ResponseEntity<?> update(Long id, RequestNewPermission updatedPermission);
}
