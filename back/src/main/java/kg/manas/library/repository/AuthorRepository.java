package kg.manas.library.repository;

import kg.manas.library.entity.BookAuthor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<BookAuthor,Long> {
    Optional<BookAuthor> findByName(String name);
}
