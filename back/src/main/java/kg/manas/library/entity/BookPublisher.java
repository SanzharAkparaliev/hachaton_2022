package kg.manas.library.entity;

import kg.manas.library.model.PublisherModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "BOOK_PUBLISHER")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookPublisher extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOOK_PUBLISHER_SEQ")
    @SequenceGenerator(name = "BOOK_PUBLISHER_SEQ", sequenceName = "BOOK_PUBLISHER_SEQ", allocationSize = 1)
    Long id;

    @Column(name = "NAME")
    String name;

    public PublisherModel toModel(){
        return PublisherModel.builder()
                .id(id)
                .name(name)
                .build();
    }
}
