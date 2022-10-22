package kg.manas.library.entity;

import kg.manas.library.model.BookAuthorModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "BOOK_AUTHOR")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookAuthor extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOOK_AUTHOR_SEQ")
    @SequenceGenerator(name = "BOOK_AUTHOR_SEQ", sequenceName = "BOOK_AUTHOR_SEQ", allocationSize = 1)
    Long id;

    @Column(name = "NAME")
    String name;

    @Lob
    @Column(name = "LIFE_DESCRIPTION", columnDefinition = "TEXT")
    String lifeDescription;

    public BookAuthorModel toModel(){
        return BookAuthorModel.builder()
                .id(id)
                .name(name)
                .lifeDescription(lifeDescription)
                .build();
    }
}
