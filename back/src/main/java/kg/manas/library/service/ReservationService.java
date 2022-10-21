package kg.manas.library.service;

import kg.manas.library.model.BookReservationModel;
import kg.manas.library.model.BookUnitModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReservationService {
    BookReservationModel getBookReservationById(Long id);
    Page<BookReservationModel> getAllBookReservations(Pageable pageable);
    List<BookReservationModel> saveBookReservations(List<BookUnitModel> bookUnitModels);
    List<BookReservationModel> submitBookReservations(List<BookReservationModel> reservationModels);
    BookReservationModel saveBookReservation(BookReservationModel bookReservationModel);
}
