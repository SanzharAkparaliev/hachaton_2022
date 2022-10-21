package kg.manas.library.service.impl;


import kg.manas.library.entity.User;
import kg.manas.library.model.RequestNewUser;
import kg.manas.library.model.UserDTO;
import kg.manas.library.repository.RoleRepository;
import kg.manas.library.repository.UserRepository;
import kg.manas.library.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserDetailsService, UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.
                findByUsernameAndRdtIsNull(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }

    @Override
    public ResponseEntity<?> register(RequestNewUser user) {
        User newUser = new User();

        if (roleRepository.findById(user.getRole()).isPresent()) {
            newUser.setUsername(user.getUsername());
            newUser.setRole(roleRepository.findById(user.getRole()).get());
            newUser.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(newUser);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else return ResponseEntity.unprocessableEntity().build();

    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
    public ResponseEntity<?> getUser(Long id) {
        return userRepository.findById(id).map(user -> {
            UserDTO userDto = new UserDTO(id, user.getUsername(),
                    user.getRole().toModel());
            return ResponseEntity.ok(userDto);
        }).orElseGet(() -> {
            log.error("user was not found");
            return ResponseEntity.unprocessableEntity().build();
        });


    }

    @Override
    public List<UserDTO> getAllUser() {
        return userRepository.findAllByRdtIsNull().orElseThrow(()-> new NoSuchElementException("Users cannot be found")).stream().map(User::toModel).collect(Collectors.toList());

    }

    @Override
    public ResponseEntity<?> deleteUser(Long id) {
        return userRepository.findById(id).map(user -> {
            user.markRemoved();
            userRepository.save(user);
            return ResponseEntity.ok().build();
        }).orElseGet(() -> {
            log.error("user was not found");
            return ResponseEntity.unprocessableEntity().build();
        });
    }

    @Override
    public ResponseEntity<?> update(Long id, RequestNewUser updatedUser) {
        return userRepository.findByIdAndRdtIsNull(id).map(user -> {
            if (roleRepository.findByIdAndRdtIsNull(updatedUser.getRole()).isPresent()) {
                user.setUsername(updatedUser.getUsername());
                user.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
                user.setRole(roleRepository.findByIdAndRdtIsNull(updatedUser.getRole()).get());
                userRepository.save(user);
                return ResponseEntity.ok().build();
            } else {
                log.error("role by this id was not found");
                return ResponseEntity.unprocessableEntity().build();
            }

        }).orElseGet(() -> {
            log.error("user was not found");
            return ResponseEntity.unprocessableEntity().build();
        });
    }
}
