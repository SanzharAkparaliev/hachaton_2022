package kg.manas.library.model;

import kg.manas.library.enums.RentStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RentDetailModel {

    Long id;
    ProductModel productModel;
    Integer amount;
    Long rentId;
    RentStatus rentStatus;
}
