package kg.manas.library.controller;

import kg.manas.library.model.BookCategoryModel;
import kg.manas.library.service.BookCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private BookCategoryService bookCategoryService;

    @GetMapping
    public List<BookCategoryModel> getAllCategory(){
        List<BookCategoryModel> categories = bookCategoryService.getAll();
        return categories;
    }

    @GetMapping("/{id}")
    public BookCategoryModel getCategoryById(@PathVariable("id") Long id){
        BookCategoryModel category = bookCategoryService.get(id);
        return category;
    }

    @PostMapping
    public ResponseEntity<BookCategoryModel> createCategory(@RequestBody BookCategoryModel bookCategoryModel){
        BookCategoryModel newCategory = bookCategoryService.save(bookCategoryModel);
        return new ResponseEntity<>(bookCategoryModel, HttpStatus.CREATED);
    }
}
