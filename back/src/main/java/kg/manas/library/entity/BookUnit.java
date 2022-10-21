package kg.manas.library.entity;

import kg.manas.library.enums.BookStatus;
import kg.manas.library.model.BookUnitModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "BOOK_UNIT")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookUnit extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOOK_UNIT_SEQ")
    @SequenceGenerator(name = "BOOK_UNIT_SEQ", sequenceName = "BOOK_UNIT_SEQ", allocationSize = 1, initialValue = 10)
    Long id;

    @ManyToOne
    @JoinColumn(name = "BOOK_GENERIC")
    BookGeneric bookGeneric;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    BookStatus status;

    @Lob
    @Column(name = "IMAGE", columnDefinition = "BYTEA")
    byte[] image;


    public BookUnitModel toModel() {
        return BookUnitModel.builder()
                .id(id)
                .bookGenericModel(bookGeneric.toModel())
                .status(status)
                .image(image)
                .build();
    }


}
