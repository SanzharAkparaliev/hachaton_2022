package kg.manas.library.repository;

import kg.manas.library.entity.BookGeneric;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookGenericRepository extends JpaRepository<BookGeneric, Long> {
}
