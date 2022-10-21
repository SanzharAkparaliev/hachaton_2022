package kg.manas.library.service;

import kg.manas.library.model.BookAuthorModel;

import java.util.List;

public interface AuthorService {
    BookAuthorModel get(Long id);

    BookAuthorModel getByName(String name);

    BookAuthorModel save(BookAuthorModel bookAuthorModelModel);

    List<BookAuthorModel> getAll();
}
