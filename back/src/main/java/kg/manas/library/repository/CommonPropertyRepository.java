package kg.manas.library.repository;

import kg.manas.library.entity.CommonProperty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommonPropertyRepository extends JpaRepository<CommonProperty, Long> {
    Optional<String> findByKey(String key);
}
