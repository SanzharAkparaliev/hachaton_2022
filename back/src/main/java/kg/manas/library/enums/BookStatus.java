package kg.manas.library.enums;

public enum BookStatus {
    AVAILABLE("Достпупен"),
    IN_USE("Находится в чтении"),
    RESERVED("Забронирован");


    String description;

    BookStatus(String description) {
        this.description = description;
    }


}
