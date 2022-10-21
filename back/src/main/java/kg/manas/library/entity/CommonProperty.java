package kg.manas.library.entity;

import kg.manas.library.model.CommonPropertyModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "COMMON_PROPERTY")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommonProperty extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMMON_PROPERTY_SEQ")
    @SequenceGenerator(name = "COMMON_PROPERTY_SEQ", sequenceName = "COMMON_PROPERTY_SEQ", allocationSize = 1)
    Long id;

    @Column(name = "KEY")
    String key;

    @Column(name = "VALUE")
    String value;

    public CommonPropertyModel toModel() {
        return CommonPropertyModel.builder()
                .id(id)
                .key(key)
                .value(value)
                .build();
    }
}
