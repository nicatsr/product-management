package az.product.service;

import az.product.model.db.Category;
import az.product.model.dto.ProductDto;
import az.product.model.dto.ProductForList;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Category> getCategoryList();

    void addProduct(ProductDto productDto);


    List<ProductForList> getProductList();

    void deleteProductById(long id);

    Optional<ProductForList> getProductById(long id);

    long getCategoryIdByName(String categoryName);

    void updateProduct(ProductDto productDto);
}
