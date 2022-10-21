package kg.manas.library.converters;

import kg.manas.library.entity.BookUnit;
import kg.manas.library.model.BookUnitModel;

public class BookUnitConverter extends ModelConverter<BookUnitModel, BookUnit>{
    public BookUnitConverter() {
        super(BookUnitConverter::convertToEntity, BookUnitConverter::convertToModel);
    }

    private static BookUnitModel convertToModel(BookUnit bookUnit) {
        BookGenericConverter bookGenericConverter = new BookGenericConverter();
        return BookUnitModel.builder()
                .id(bookUnit.getId())
                .image(bookUnit.getImage())
                .status(bookUnit.getStatus())
                .bookGenericModel(bookGenericConverter.convertFromEntity(bookUnit.getBookGeneric()))
                .build();
    }

    private static BookUnit convertToEntity(BookUnitModel bookUnitModel) {
        if (bookUnitModel == null)
            return new BookUnit();
        BookGenericConverter bookGenericConverter = new BookGenericConverter();
        BookUnit bookUnit = new BookUnit();
        bookUnit.setId(bookUnitModel.getId());
        bookUnit.setImage(bookUnitModel.getImage());
        bookUnit.setStatus(bookUnitModel.getStatus());
        bookUnit.setBookGeneric(bookGenericConverter.convertFromModel(bookUnitModel.getBookGenericModel()));
        return bookUnit;
    }
}
