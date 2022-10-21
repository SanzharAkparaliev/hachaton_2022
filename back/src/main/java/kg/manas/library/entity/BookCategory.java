package kg.manas.library.entity;


import kg.manas.library.model.BookCategoryModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "CATEGORIES")
public class BookCategory extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATEGORY_SEQ")
    @SequenceGenerator(name = "SEQ_ID", sequenceName = "CATEGORY_SEQ", allocationSize = 1, initialValue = 10)
    private Long id;

    @Column(name = "CATEGORY_NAME")
    private String categoryName;

    public BookCategoryModel toModel() {
        return BookCategoryModel.builder()
                .id(id)
                .categoryName(categoryName)
                .build();
    }

}
