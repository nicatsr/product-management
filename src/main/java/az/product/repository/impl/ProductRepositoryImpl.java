package az.product.repository.impl;

import az.product.model.db.Category;
import az.product.model.db.Product;
import az.product.model.dto.ProductForList;
import az.product.repository.ProductRepository;
import az.product.repository.query.ProductQuery;
import az.product.repository.rowmapper.CategoryRowMapper;
import az.product.repository.rowmapper.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    CategoryRowMapper categoryRowMapper;

    @Override
    public List<Category> getCategoryList() {
        return jdbcTemplate.query(ProductQuery.GET_CATEGORY_LIST,categoryRowMapper);
    }

    @Override
    public void addProduct(Product product) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("name" , product.getName());
        parameterSource.addValue("category_id" , product.getCategoryId());
        parameterSource.addValue("description" , product.getDescription());
        parameterSource.addValue("photo_id" , product.getPhotoId() > 0 ? product.getPhotoId() : 42);
        parameterSource.addValue("idate" , LocalDateTime.now());
        parameterSource.addValue("udate" , LocalDateTime.now());
        int count = namedParameterJdbcTemplate.update(ProductQuery.INSERT_PRODUCT,parameterSource);
       if (count < 1){
           throw new RuntimeException("error adding product");
       }
    }
    @Autowired
    private ProductRowMapper productRowMapper;

    @Override
    public List<ProductForList> getProductList() {
        return jdbcTemplate.query(ProductQuery.GET_PRODUCT_LIST ,productRowMapper);
    }

    @Override
    public void deleteProductById(long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource("id" , id);
        int count = namedParameterJdbcTemplate.update(ProductQuery.DELETE_PRODUCT_BY_ID ,parameterSource);
        if (count < 1){
            throw new RuntimeException("error deleting product with id " + id);
        }
    }

    @Override
    public Optional<ProductForList> getProductForListById(long id) {
        Optional<ProductForList> optionalProductForList = Optional.empty();
        Object[] args = new Object[]{id};
        List<ProductForList> list =
                jdbcTemplate.query(ProductQuery.GET_PRODUCT_BY_ID ,productRowMapper ,args);
        if (!list.isEmpty()){
            optionalProductForList = Optional.of(list.get(0));
        }
        return optionalProductForList;
    }


    @Override
    public long getCategoryIdByName(String categoryName) {
        Object[] args = new Object[]{categoryName};
        List<Category> list = jdbcTemplate.query(ProductQuery.GET_CATEGORY_BY_NAME ,categoryRowMapper , categoryName);
        if (!list.isEmpty()){
            return list.get(0).getId();
        }

        return 0;
    }

    @Override
    public void updateProduct(Product product) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id" ,product.getId());
        parameterSource.addValue("name" , product.getName());
        parameterSource.addValue("category_id" , product.getCategoryId());
        parameterSource.addValue("description" , product.getDescription());
        parameterSource.addValue("photo_id" , product.getPhotoId());
        parameterSource.addValue("udate" , LocalDateTime.now());

        int count =
                namedParameterJdbcTemplate.update(ProductQuery.UPDATE_PRODUCT ,parameterSource);
        if (count < 1){
            throw new RuntimeException("error updating product");
        }
    }

    @Override
    public boolean photoExists(long photoId) {
        boolean checkExits = false;
        MapSqlParameterSource parameterSource = new MapSqlParameterSource("photo_id" , photoId);
        int count = namedParameterJdbcTemplate.queryForObject(ProductQuery.CHECK_PHOTO_EXISTS,parameterSource ,Integer.class);
        if (count > 0){
            checkExits = true;
        }
        return checkExits;
    }
}
