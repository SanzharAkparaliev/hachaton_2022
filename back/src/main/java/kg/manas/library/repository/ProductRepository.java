package kg.manas.library.repository;

import kg.manas.library.entity.BookGeneric;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<BookGeneric, Long> {
}
