package kg.manas.library.service.impl;

import kg.manas.library.entity.BookCategory;
import kg.manas.library.model.BookCategoryModel;
import kg.manas.library.repository.BookCategoryRepository;
import kg.manas.library.service.BookCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookCategoryServiceImpl implements BookCategoryService {

    private final BookCategoryRepository bookCategoryRepository;


    @Override
    public BookCategoryModel get(Long id) {
        return bookCategoryRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Category by id: " + id + " cannot be found !"))
                .toModel();
    }

    @Override
    public BookCategoryModel save(BookCategoryModel bookCategoryModel) {
        BookCategory bookCategory = bookCategoryModel.getId() == null ? new BookCategory() : bookCategoryRepository.getById(bookCategoryModel.getId());
        bookCategory.setCategoryName(bookCategoryModel.getCategoryName());
        return bookCategoryRepository.save(bookCategory).toModel();
    }

    @Override
    public List<BookCategoryModel> getAll() {
        return bookCategoryRepository.findAll().stream()
                .map(BookCategory::toModel).collect(Collectors.toList());
    }
}
