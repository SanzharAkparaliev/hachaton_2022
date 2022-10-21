package kg.manas.library.service;

import kg.manas.library.model.BookGenericModel;
import kg.manas.library.model.BookUnitModel;

import java.util.List;

public interface BookUnitService {
    BookUnitModel getBookUnitById(Long id);
    List<BookUnitModel> getAllBookUnits();
    BookUnitModel saveBookUnit(BookUnitModel bookUnitModel);
    List<BookUnitModel> saveBookUnitsByBookGeneric(BookGenericModel bookGenericModel, Integer booksAmount, byte[] image);
}
