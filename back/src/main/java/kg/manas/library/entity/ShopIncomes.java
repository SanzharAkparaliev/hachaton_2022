package kg.manas.library.entity;


import kg.manas.library.model.RentModel;
import kg.manas.library.model.ShopIncomesModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Month;

@Getter
@Setter
@Entity
@Table(name = "SHOP_INCOMES")
public class ShopIncomes extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SHOP_INCOMES_SEQ")
    @SequenceGenerator(name = "SEQ_ID", sequenceName = "SHOP_INCOMES_SEQ", allocationSize = 1, initialValue = 10)
    private Long id;

    @OneToOne
    @JoinColumn(name = "SHOP_ID", referencedColumnName = "ID")
    private Shop shop;

    private Month month;

    @ManyToOne
    @JoinColumn(name = "RENT_ID", referencedColumnName = "ID")
    private Rent rent;

    public ShopIncomesModel toModel() {
        return ShopIncomesModel.builder()
                .id(id)
                .shop(shop.toModel())
                .month(month)
                .rent(rent != null? rent.toModel() : new RentModel()).build();
    }
}
