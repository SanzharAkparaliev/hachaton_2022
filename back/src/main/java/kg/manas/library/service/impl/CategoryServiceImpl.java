package kg.manas.library.service.impl;

import kg.manas.library.entity.BookCategory;
import kg.manas.library.model.CategoryModel;
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
    public CategoryModel get(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Category by id: " + id + " cannot be found !"))
                .toModel();
    }

    @Override
    public CategoryModel save(CategoryModel categoryModel) {
        BookCategory bookCategory = categoryModel.getId() == null ? new BookCategory() : categoryRepository.getById(categoryModel.getId());
        bookCategory.setCategoryName(categoryModel.getCategoryName());
        return categoryRepository.save(bookCategory).toModel();
    }

    @Override
    public List<CategoryModel> getAll() {
        return categoryRepository.findAll().stream()
                .map(BookCategory::toModel).collect(Collectors.toList());
    }
}
