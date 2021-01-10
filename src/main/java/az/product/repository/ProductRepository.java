package az.product.repository;

import az.product.model.db.Category;
import az.product.model.db.Product;
import az.product.model.dto.ProductForList;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Category> getCategoryList();

    void addProduct(Product product);

    List<ProductForList> getProductList();

    void deleteProductById(long id);

    Optional<ProductForList> getProductForListById(long id);

    long getCategoryIdByName(String categoryName);

    void updateProduct(Product product);

    boolean photoExists(long photoId);
}
