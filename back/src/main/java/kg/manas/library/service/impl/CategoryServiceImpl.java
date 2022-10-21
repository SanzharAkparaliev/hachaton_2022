package kg.manas.library.service.impl;

import kg.manas.library.entity.BookCategory;
import kg.manas.library.model.BookCategoryModel;
import kg.manas.library.repository.CategoryRepository;
import kg.manas.library.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;


    @Override
    public BookCategoryModel get(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Category by id: " + id + " cannot be found !"))
                .toModel();
    }

    @Override
    public BookCategoryModel save(BookCategoryModel bookCategoryModel) {
        BookCategory bookCategory = bookCategoryModel.getId() == null ? new BookCategory() : categoryRepository.getById(bookCategoryModel.getId());
        bookCategory.setCategoryName(bookCategoryModel.getCategoryName());
        return categoryRepository.save(bookCategory).toModel();
    }

    @Override
    public List<BookCategoryModel> getAll() {
        return categoryRepository.findAll().stream()
                .map(BookCategory::toModel).collect(Collectors.toList());
    }
}
