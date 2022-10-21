package kg.manas.library.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookGenericModel {
    Long id;
    String name;
    BookCategoryModel bookCategory;
    BookAuthorModel bookAuthor;
    String edition;
}
