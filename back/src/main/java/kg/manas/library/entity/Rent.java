package kg.manas.library.entity;


import kg.manas.library.model.RentModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "RENTS")
public class Rent extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RENT_SEQ")
    @SequenceGenerator(name = "SEQ_ID", sequenceName = "RENT_SEQ", allocationSize = 1, initialValue = 10)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    private User user;

    @Column(name = "DATE_OF_RENT")
    private LocalDateTime dateOfRent;

    @Column(name = "DURATION")
    private LocalDateTime duration;

    @Column(name = "TOTAL_SUM")
    private Double totalSum;

    @Column(name = "NOTE")
    String note;


    public RentModel toModel() {
        return RentModel.builder()
                .id(id)
                .userModel(user.toModel())
                .note(note)
                .build();
    }
}
