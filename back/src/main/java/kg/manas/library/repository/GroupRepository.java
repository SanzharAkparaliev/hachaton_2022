package kg.manas.library.repository;

import kg.manas.library.entity.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<UserGroup,Long> {
}
