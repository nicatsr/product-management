package az.product.repository.rowmapper;

import az.product.model.db.Category;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class CategoryRowMapper implements RowMapper<Category> {
    @Override
    public Category mapRow(ResultSet rs, int i) throws SQLException {
        Category category = new Category();
        category.setId(rs.getLong("id"));
        category.setName(rs.getString("name"));
        category.setIdate(rs.getTimestamp("idate").toLocalDateTime());
        category.setUdate(rs.getTimestamp("udate").toLocalDateTime());
        return category;
    }
}
