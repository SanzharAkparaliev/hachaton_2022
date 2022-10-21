package kg.manas.library.entity;

import kg.manas.library.enums.ReservationStatus;
import kg.manas.library.model.BookReservationModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "BOOK_RESERVATIONS")
public class BookReservation extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOOK_RESERVATION_SEQ")
    @SequenceGenerator(name = "BOOK_RESERVATION_SEQ", sequenceName = "BOOK_RESERVATION_SEQ", allocationSize = 1, initialValue = 10)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "BOOK_UNIT_ID")
    BookUnit bookUnit;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    User user;

    @Column(name = "RESERVATION_END_DATE")
    LocalDateTime reservationEndDate;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    ReservationStatus status;

    @Column(name = "EXTENEDED_COUNT")
    Integer extendedCount;

    @Column(name = "NUMBER_OF_DAYS_PAST_DUE")
    Integer numberOfDaysPastDue;

    @Column(name = "PASSED_DATE")
    LocalDateTime passedDate;

    @Column(name = "COMMENT")
    String comment;


    public BookReservationModel toModel() {
        return BookReservationModel.builder()
                .id(id)
                .bookUnitModel(bookUnit.toModel())
                .userModel(user.toModel())
                .reservationEndDate(reservationEndDate)
                .status(status)
                .extendedCount(extendedCount)
                .numberOfDaysPastDue(numberOfDaysPastDue)
                .passedDate(passedDate)
                .comment(comment)
                .build();
    }
}
