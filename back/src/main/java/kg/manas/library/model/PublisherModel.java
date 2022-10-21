package kg.manas.library.model;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PublisherModel {
    Long id;
    String name;
}
