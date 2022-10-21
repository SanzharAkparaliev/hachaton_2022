package kg.manas.library.model;

import kg.manas.library.enums.Season;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductModel {

    Long id;
    String productName;
    CategoryModel categoryModel;
    Season season;
    ShopModel shopModel;
    Double price;
}
