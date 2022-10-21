package kg.manas.library.service;


import kg.manas.library.entity.User;
import kg.manas.library.model.RequestNewUser;
import kg.manas.library.model.UserDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    ResponseEntity<?> register(RequestNewUser user);

    ResponseEntity<?> getUser(Long id);

    List<UserDTO> getAllUser();

    ResponseEntity<?> deleteUser(Long id);

    ResponseEntity<?> update(Long id, RequestNewUser updatedUser);

    User getCurrentUser();
}
