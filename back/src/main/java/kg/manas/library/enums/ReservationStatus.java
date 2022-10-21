package kg.manas.library.enums;

public enum ReservationStatus {

    RESERVED("Забронировано"),
    IN_USE("Находится в чтении"),
    OVERDUE("Просрочен"),
    EXTENDED("Продлен"),
    PASSED("Сдан");

    String description;

    ReservationStatus(String description) {
        this.description = description;
    }
}
