package kg.manas.library.controller;



import kg.manas.library.model.RequestNewUser;
import kg.manas.library.model.UserDTO;
import kg.manas.library.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RequestNewUser user) {
        return userService.register(user);
    }

    @GetMapping("/get-one/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<UserDTO>> getAllUser() {
        return ResponseEntity.ok(userService.getAllUser());
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable  Long id, @RequestBody RequestNewUser newUser){
        return userService.update(id, newUser);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable  Long id){
        return userService.deleteUser(id);
    }

}
