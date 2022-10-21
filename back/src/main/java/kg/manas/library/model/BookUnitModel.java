package kg.manas.library.model;

import kg.manas.library.enums.BookStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookUnitModel {
    Long id;
    BookGenericModel bookGenericModel;
    BookStatus status;
    byte[] image;
}
