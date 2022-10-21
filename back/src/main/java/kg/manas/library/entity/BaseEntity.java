package kg.manas.library.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity {
    private LocalDateTime cdt;
    private LocalDateTime udt;
    private LocalDateTime rdt;

    @PrePersist
    public void prePersist() {
        this.cdt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.udt = LocalDateTime.now();
    }

    public void markRemoved() {
        this.rdt = LocalDateTime.now();
    }
}