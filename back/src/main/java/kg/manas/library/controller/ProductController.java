package kg.manas.library.controller;

import kg.manas.library.model.ProductModel;
import kg.manas.library.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductModel> save(@RequestBody  ProductModel productModel) {
        return ResponseEntity.ok(productService.save(productModel));
    }

    @GetMapping("/getById")
    public ResponseEntity<ProductModel> get(@RequestParam Long id) {
        return ResponseEntity.ok(productService.get(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ProductModel>> getAll() {
        return ResponseEntity.ok(productService.getAll());
    }
}
