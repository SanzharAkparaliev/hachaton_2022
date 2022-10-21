package kg.manas.library.controller;

import kg.manas.library.entity.BookCategory;
import kg.manas.library.model.CategoryModel;
import kg.manas.library.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<CategoryModel> getAllCategory(){
        List<CategoryModel> categories = categoryService.getAll();
        return categories;
    }

    @GetMapping("/{id}")
    public CategoryModel getCategoryById(@PathVariable("id") Long id){
        CategoryModel category = categoryService.get(id);
        return category;
    }

    @PostMapping
    public ResponseEntity<CategoryModel> createCategory(@RequestBody CategoryModel categoryModel){
        CategoryModel newCategory = categoryService.save(categoryModel);
        return new ResponseEntity<>(categoryModel, HttpStatus.CREATED);
    }
}
