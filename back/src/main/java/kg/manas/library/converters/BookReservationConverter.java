package kg.manas.library.converters;

import kg.manas.library.entity.BookReservation;
import kg.manas.library.entity.BookUnit;
import kg.manas.library.entity.User;
import kg.manas.library.model.BookReservationModel;
import kg.manas.library.repository.BookUnitRepository;
import kg.manas.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public class BookReservationConverter extends ModelConverter<BookReservationModel,BookReservation>{
    public BookReservationConverter() {
        super(BookReservationConverter::convertToEntity, BookReservationConverter::convertToModel);
    }

    private static BookUnitRepository bookUnitRepository;
    private static UserRepository userRepository;

    @Autowired
    public static void setBookUnitRepository(BookUnitRepository bookUnitRepository) {
        BookReservationConverter.bookUnitRepository = bookUnitRepository;
    }

    @Autowired
    public static void setUserRepository(UserRepository userRepository) {
        BookReservationConverter.userRepository = userRepository;
    }

    private static BookReservation convertToEntity(BookReservationModel bookReservationModel) {
        if (bookReservationModel == null)
            return new BookReservation();
        BookUnit bookUnit = bookUnitRepository.findById(bookReservationModel.getBookUnitModel().getId()).orElseThrow(NoSuchElementException::new);
        User user = userRepository.findById(bookReservationModel.getUserModel().getId()).orElseThrow(NoSuchElementException::new);
        BookReservation bookReservation = new BookReservation();
        bookReservation.setId(bookReservationModel.getId());
        bookReservation.setBookUnit(bookUnit);
        bookReservation.setUser(user);
        bookReservation.setStatus(bookReservationModel.getStatus());
        bookReservation.setReservationEndDate(bookReservationModel.getReservationEndDate());
        bookReservation.setExtendedCount(bookReservationModel.getExtendedCount());
        bookReservation.setNumberOfDaysPastDue(bookReservationModel.getNumberOfDaysPastDue());
        bookReservation.setComment(bookReservationModel.getComment());
        bookReservation.setPassedDate(bookReservationModel.getPassedDate());
        return bookReservation;
    }

    private static BookReservationModel convertToModel(BookReservation bookReservation) {
        if (bookReservation == null)
            return new BookReservationModel();
        return BookReservationModel.builder()
                .id(bookReservation.getId())
                .bookUnitModel(bookReservation.getBookUnit().toModel())
                .userModel(bookReservation.getUser().toModel())
                .reservationEndDate(bookReservation.getReservationEndDate())
                .status(bookReservation.getStatus())
                .extendedCount(bookReservation.getExtendedCount())
                .numberOfDaysPastDue(bookReservation.getNumberOfDaysPastDue())
                .passedDate(bookReservation.getPassedDate())
                .comment(bookReservation.getComment())
                .build();
    }
}
