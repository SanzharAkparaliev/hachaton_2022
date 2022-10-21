package kg.manas.library.repository;

import kg.manas.library.entity.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<BookCategory, Long> {
}
