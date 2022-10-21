package kg.manas.library.model;

import kg.manas.library.enums.ReservationStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookReservationModel {
    Long id;
    BookUnitModel bookUnitModel;
    UserDTO userModel;
    LocalDateTime reservationEndDate;
    ReservationStatus status;
    Integer extendedCount;
    Integer numberOfDaysPastDue;
    LocalDateTime passedDate;
    String comment;
}
