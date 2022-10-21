package kg.manas.library.service.impl;

import kg.manas.library.entity.BookGeneric;
import kg.manas.library.entity.BookCategory;
import kg.manas.library.entity.Shop;
import kg.manas.library.model.ProductModel;
import kg.manas.library.repository.CategoryRepository;
import kg.manas.library.repository.ProductRepository;
import kg.manas.library.repository.ShopRepository;
import kg.manas.library.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ShopRepository shopRepository;

    @Override
    public ProductModel get(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Product by id: " + id + " cannot be found")).toModel();
    }

    @Override
    public ProductModel save(ProductModel productModel) {
        BookCategory bookCategory = categoryRepository.findById(productModel.getCategoryModel().getId()).orElseThrow(() -> new NoSuchElementException("Category by id: " + productModel.getCategoryModel().getId() + " cannot be found"));
        Shop shop = shopRepository.findById(productModel.getShopModel().getId()).orElseThrow(() -> new NoSuchElementException("Shop by id: " + productModel.getShopModel().getId() + " cannot be found"));
        BookGeneric bookGeneric = productModel.getId() != null ?
                productRepository.findById(productModel.getId())
                        .orElseThrow(() -> new NoSuchElementException("Product by id: " + productModel.getId() + " cannot be found")) : new BookGeneric();
        return productRepository.save(bookGeneric).toModel();
    }

    @Override
    public List<ProductModel> getAll() {
        return productRepository.findAll().stream().map(BookGeneric::toModel).collect(Collectors.toList());
    }

    @Override
    public ProductModel delete(Long id) {
        BookGeneric bookGeneric = productRepository.findById(id) .orElseThrow(() -> new NoSuchElementException("Product by id: " + id + " cannot be found"));
        bookGeneric.markRemoved();
        return productRepository.save(bookGeneric).toModel();
    }
}
