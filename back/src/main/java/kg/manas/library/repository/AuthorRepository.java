package kg.manas.library.repository;

import kg.manas.library.entity.BookAuthor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<BookAuthor,Long> {
}
