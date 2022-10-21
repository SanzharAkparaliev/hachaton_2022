package kg.manas.library.service.impl;

import kg.manas.library.converters.BookReservationConverter;
import kg.manas.library.converters.BookUnitConverter;
import kg.manas.library.entity.BookReservation;
import kg.manas.library.entity.BookUnit;
import kg.manas.library.entity.User;
import kg.manas.library.enums.CommonProperty;
import kg.manas.library.enums.ReservationStatus;
import kg.manas.library.model.BookReservationModel;
import kg.manas.library.model.BookUnitModel;
import kg.manas.library.repository.ReservationRepository;
import kg.manas.library.service.CommonPropertyService;
import kg.manas.library.service.ReservationService;
import kg.manas.library.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;
    private final UserService userService;
    private final BookUnitConverter bookUnitConverter;
    private final BookReservationConverter bookReservationConverter;
    private final CommonPropertyService commonPropertyService;

    @Override
    public BookReservationModel getBookReservationById(Long id) {
        return reservationRepository.findById(id).orElseThrow(NoSuchElementException::new).toModel();
    }

    @Override
    public Page<BookReservationModel> getAllBookReservations(Pageable pageable) {
        Page<BookReservation> bookReservations = reservationRepository.findAll(pageable);
        return bookReservations.map(BookReservation::toModel);
    }

    @Override
    public List<BookReservationModel> saveBookReservations(List<BookUnitModel> bookUnitModels) {
        User currentUser = userService.getCurrentUser();
        List<BookReservationModel> bookReservations = new ArrayList<>();
        List<BookReservation> currentUserReservations = this.getAllReservationsByUser(currentUser);
        Integer maxAllowedReservations = commonPropertyService.getIntegerValueByKey(CommonProperty.MAX_ALLOWED_RESERVATIONS);
        Long reservationDaysAmount = Long.valueOf(commonPropertyService.getStringValueByKey(CommonProperty.RESERVATION_DAYS_AMOUNT));
        if (currentUserReservations.size() == maxAllowedReservations)
            throw new UnsupportedOperationException("maximum allowed reservation count is exceed");
        bookUnitModels.forEach(bookUnitModel -> {
            BookUnit bookUnit = bookUnitConverter.convertFromModel(bookUnitModel);
            BookReservation bookReservation = new BookReservation();
            bookReservation.setBookUnit(bookUnit);
            bookReservation.setUser(currentUser);
            bookReservation.setStatus(ReservationStatus.RESERVED);
            bookReservation.setReservationEndDate(LocalDateTime.now().plusDays(reservationDaysAmount));
            bookReservations.add(bookReservationConverter.convertFromEntity(reservationRepository.save(bookReservation)));
        });
        return bookReservations;
    }

    @Override
    public List<BookReservationModel> submitBookReservations(List<BookReservationModel> reservationModels) {
//        List<BookReservation> reservations =
//                reservationModels.stream().map(bookReservationModel -> {
//
//                    bookReservationModel.set
//                }).collect(Collectors.toList());
//
//        return reservationRepository.saveAll(reservations).stream().map(bookReservationConverter::convertFromEntity).collect(Collectors.toList());
        return null;
    }

    @Override
    public BookReservationModel saveBookReservation(BookReservationModel bookReservationModel) {
        BookReservation bookReservation = bookReservationConverter.convertFromModel(bookReservationModel);
        Integer maxAllowedExtensionsCount = commonPropertyService.getIntegerValueByKey(CommonProperty.EXTENSION_MAX_ALLOWED_DAYS);
        Integer reservationAllowedDays = commonPropertyService.getIntegerValueByKey(CommonProperty.RESERVATION_ALLOWED_DAYS);
        if (bookReservationModel.getStatus().equals(ReservationStatus.EXTENDED) && bookReservationModel.getExtendedCount().equals(maxAllowedExtensionsCount))
            throw new UnsupportedOperationException("maximum allowed extension count is exceed");
        else if (bookReservationModel.getStatus().equals(ReservationStatus.EXTENDED) && bookReservationModel.getExtendedCount() < maxAllowedExtensionsCount)
            bookReservation.setReservationEndDate(bookReservationModel.getReservationEndDate().plusDays(reservationAllowedDays));
        else if (bookReservationModel.getStatus().equals(ReservationStatus.PASSED))
            bookReservation.setPassedDate(LocalDateTime.now());
        return bookReservationConverter.convertFromEntity(reservationRepository.save(bookReservation));
    }

    private List<BookReservation> getAllReservationsByUser(User user) {
        return reservationRepository.findAllByUser(user).orElse(new ArrayList<>());
    }


}
