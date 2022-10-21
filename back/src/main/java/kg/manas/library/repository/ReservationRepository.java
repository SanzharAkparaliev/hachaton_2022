package kg.manas.library.repository;

import kg.manas.library.entity.BookReservation;
import kg.manas.library.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<BookReservation,Long> {
    Optional<List<BookReservation>> findAllByUser(User user);
}
