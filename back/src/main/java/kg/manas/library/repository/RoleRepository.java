package kg.manas.library.repository;


import kg.manas.library.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByRoleNameAndRdtIsNull(String roleName);

    Optional<Role> findByIdAndRdtIsNull(Long id);

    Optional<List<Role>> findAllByRdtIsNull();
}
