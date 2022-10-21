package kg.manas.library.model;

import lombok.*;

import java.time.Month;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShopIncomesModel {

    Long id;
    ShopModel shop;
    Month month;
    RentModel rent;
}
