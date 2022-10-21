package kg.manas.library.model;


import lombok.*;
import lombok.experimental.FieldDefaults;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookAuthorModel {
    Long id;
    String name;
    String lifeDescription;
}
