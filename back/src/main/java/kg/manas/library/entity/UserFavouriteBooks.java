package kg.manas.library.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "USER_FAVOURITE_BOOKS")
public class UserFavouriteBooks extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_FAVOURITE_BOOK_SEQ")
    @SequenceGenerator(name = "USER_FAVOURITE_BOOK_ID", sequenceName = "USER_FAVOURITE_BOOK_SEQ", allocationSize = 1)
    private Long id;

    @OneToOne
    @JoinColumn(name = "USER_ID")
    User user;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinTable(name = "USER_HAS_FAVOURITE_BOOKS",
            joinColumns = {@JoinColumn(name = "USER_FAVOURITE_BOOK_ENTITY_ID")},
            inverseJoinColumns = {@JoinColumn(name = "BOOK_ID")})
    List<BookGeneric> books;
}
