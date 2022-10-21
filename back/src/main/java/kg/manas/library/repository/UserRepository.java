package kg.manas.library.repository;


import kg.manas.library.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsernameAndRdtIsNull(String username);

    Optional<List<User>> findAllByRdtIsNull();

    Optional<User> findByIdAndRdtIsNull(Long id);

}
