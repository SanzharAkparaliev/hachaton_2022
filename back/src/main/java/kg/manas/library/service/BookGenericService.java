package kg.manas.library.service;

import kg.manas.library.model.BookGenericModel;

import java.util.List;

public interface BookGenericService {
    BookGenericModel getBookGenericById(Long id);
    List<BookGenericModel> getAllBookGenerics();
    BookGenericModel saveBookGeneric(BookGenericModel bookGenericModel);
}
