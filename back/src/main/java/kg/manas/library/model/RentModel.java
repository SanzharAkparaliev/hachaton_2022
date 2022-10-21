package kg.manas.library.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RentModel {
    Long id;
    UserDTO userModel;
    List<RentDetailModel> rentDetailModels;
    String note;
    LocalDateTime dateOfRent;
    LocalDateTime duration;
    Double totalSum;
}
