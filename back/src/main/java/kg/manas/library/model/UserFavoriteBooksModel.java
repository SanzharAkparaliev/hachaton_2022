package kg.manas.library.model;

import kg.manas.library.entity.BookGeneric;
import kg.manas.library.entity.User;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserFavoriteBooksModel {
    private Long id;
    User user;
    List<BookGeneric> books;
}
