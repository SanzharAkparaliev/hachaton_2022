package kg.manas.library.service;

import kg.manas.library.model.BookCategoryModel;

import java.util.List;


public interface CategoryService {
    BookCategoryModel get(Long id);

    BookCategoryModel save(BookCategoryModel bookCategoryModel);

    List<BookCategoryModel> getAll();

}
