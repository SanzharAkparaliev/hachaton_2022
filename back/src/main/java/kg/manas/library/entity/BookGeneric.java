package kg.manas.library.entity;


import kg.manas.library.model.ProductModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "BOOK_GENERIC")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookGeneric extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOOK_GENERIC_SEQ")
    @SequenceGenerator(name = "BOOK_GENERIC_SEQ", sequenceName = "BOOK_GENERIC_SEQ", allocationSize = 1)
    Long id;

    @Column(name = "NAME")
    String name;

    @ManyToOne
    @JoinColumn(name = "BOOK_CATEGORY_ID", referencedColumnName = "ID")
    BookCategory bookCategory;

    @ManyToOne
    @JoinColumn(name = "BOOK_AUTHOR_ID", referencedColumnName = "ID")
    BookAuthor bookAuthor;

    @Column(name = "BOOK_EDITION")
    String edition;

    public ProductModel toModel(){
        return ProductModel.builder()
                .id(id)
                .categoryModel(bookCategory.toModel())
                .build();
    }


}
