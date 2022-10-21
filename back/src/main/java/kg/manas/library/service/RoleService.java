package kg.manas.library.service;


import kg.manas.library.model.RequestNewRole;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface RoleService {

    ResponseEntity<?> register(RequestNewRole role);

    ResponseEntity<?> getRole(Long id);

    ResponseEntity<?> getAllRoles();

    ResponseEntity<?> deleteRole(Long id);

    ResponseEntity<?> update(Long id, RequestNewRole updatedRole);
}
