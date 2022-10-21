package kg.manas.library.controller;



import kg.manas.library.model.RequestNewRole;
import kg.manas.library.service.RoleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/role")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoleController {

    final RoleService roleService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RequestNewRole newRole) {
        return roleService.register(newRole);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRole(@PathVariable Long id) {
        return roleService.getRole(id);
    }

    @GetMapping("/all")
    //@PreAuthorize("hasAuthority('asd')")
    public ResponseEntity<?> getAllRoles() {
        return roleService.getAllRoles();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRole(@PathVariable Long id) {
        return roleService.deleteRole(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateRole(@PathVariable Long id, @RequestBody RequestNewRole newRole) {
        return roleService.update(id, newRole);
    }
}
