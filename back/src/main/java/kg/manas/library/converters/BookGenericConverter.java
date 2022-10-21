package kg.manas.library.converters;

import kg.manas.library.entity.BookAuthor;
import kg.manas.library.entity.BookCategory;
import kg.manas.library.entity.BookGeneric;
import kg.manas.library.model.BookGenericModel;
import kg.manas.library.repository.BookAuthorRepository;
import kg.manas.library.repository.BookCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public class BookGenericConverter extends ModelConverter<BookGenericModel, BookGeneric>{
    public BookGenericConverter() {
        super(BookGenericConverter::convertToEntity, BookGenericConverter::convertToModel);
    }

    private static BookCategoryRepository bookCategoryRepository;
    private static BookAuthorRepository bookAuthorRepository;

    @Autowired
    public static void setBookCategoryService(BookCategoryRepository bookCategoryRepository) {
        BookGenericConverter.bookCategoryRepository = bookCategoryRepository;
    }

    @Autowired
    public static void setBookAuthorRepository(BookAuthorRepository bookAuthorRepository) {
        BookGenericConverter.bookAuthorRepository = bookAuthorRepository;
    }

    private static BookGenericModel convertToModel(BookGeneric bookGeneric) {
       return BookGenericModel.builder()
                .id(bookGeneric.getId())
                .name(bookGeneric.getName())
                .bookCategory(bookGeneric.getBookCategory().toModel())
                .bookAuthor(bookGeneric.getBookAuthor().toModel())
                .edition(bookGeneric.getEdition())
                .build();
    }


    private static BookGeneric convertToEntity(BookGenericModel bookGenericModel) {
        if (bookGenericModel == null)
            return new BookGeneric();
        BookCategory bookCategory = bookCategoryRepository.findById(bookGenericModel.getBookCategory().getId()).orElseThrow(NoSuchElementException::new);
        BookAuthor bookAuthor = bookAuthorRepository.findById(bookGenericModel.getBookAuthor().getId()).orElseThrow(NoSuchElementException::new);
        BookGeneric bookGeneric = new BookGeneric();
        bookGeneric.setId(bookGenericModel.getId());
        bookGeneric.setBookCategory(bookCategory);
        bookGeneric.setBookAuthor(bookAuthor);
        bookGeneric.setEdition(bookGenericModel.getEdition());
        return bookGeneric;
    }
}
