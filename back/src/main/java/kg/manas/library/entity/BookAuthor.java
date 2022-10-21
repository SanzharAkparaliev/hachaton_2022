package kg.manas.library.entity;

import kg.manas.library.model.AuthorModel;
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

    @Column(name = "LIFE_DESCRIPTION")
    String lifeDescription;

    public AuthorModel toModel(){
        return AuthorModel.builder()
                .id(id)
                .name(name)
                .lifeDescription(lifeDescription)
                .build();
    }
}
