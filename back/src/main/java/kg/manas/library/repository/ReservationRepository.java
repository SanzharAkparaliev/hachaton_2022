package kg.manas.library.repository;

import kg.manas.library.entity.BookPublisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<BookPublisher,Long> {
}
