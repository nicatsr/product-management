package az.product.repository.rowmapper;

import az.product.model.db.Photo;
import az.product.model.dto.ProductForList;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ProductRowMapper implements RowMapper<ProductForList> {
    @Override
    public ProductForList mapRow(ResultSet rs, int i) throws SQLException {
        ProductForList product = new ProductForList();
        product.setName(rs.getString(1));
        product.setCategoryName(rs.getString(2));
        product.setDescription(rs.getString("description"));
        product.setPhotoId(rs.getLong("photo_id"));
        product.setId(rs.getLong("id"));
        return product;
    }
}
