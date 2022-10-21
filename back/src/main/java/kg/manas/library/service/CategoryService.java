package kg.manas.library.service;

import kg.manas.library.model.CategoryModel;

import java.util.List;


public interface CategoryService {
    CategoryModel get(Long id);

    CategoryModel save(CategoryModel categoryModel);

    List<CategoryModel> getAll();

}
