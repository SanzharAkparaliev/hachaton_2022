package kg.manas.library.controller;


import kg.manas.library.model.RequestNewPermission;
import kg.manas.library.service.PermissionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/permission")
public class PermissionController {

    final PermissionService permissionService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RequestNewPermission newPermission) {
        return permissionService.register(newPermission);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPermission(@PathVariable Long id) {
        return permissionService.getPermission(id);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllPermissions() {
        return permissionService.getAllPermissions();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePermission(@PathVariable Long id) {
        return permissionService.deletePermission(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePermission(@PathVariable Long id, @RequestBody RequestNewPermission newPermission) {
        return permissionService.update(id, newPermission);
    }
}
