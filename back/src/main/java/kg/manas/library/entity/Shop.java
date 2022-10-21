package kg.manas.library.entity;

import kg.manas.library.model.ShopModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "SHOPS")
public class Shop extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SHOP_SEQ")
    @SequenceGenerator(name = "SEQ_ID", sequenceName = "SHOP_SEQ", allocationSize = 1, initialValue = 10)
    private Long id;


    @Column(name = "SHOP_NAME")
    private String shopName;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    public ShopModel toModel() {
        return ShopModel.builder()
                .id(id)
                .shopName(shopName)
                .address(address)
                .phoneNumber(phoneNumber)
                .build();
    }
}
