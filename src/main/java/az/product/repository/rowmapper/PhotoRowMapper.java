package az.product.repository.rowmapper;


import az.product.model.db.Photo;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

@Component
public class PhotoRowMapper implements RowMapper<Photo> {
    @Override
    public Photo mapRow(ResultSet rs, int i) throws SQLException {
        Photo photo = new Photo();
        photo.setId(rs.getLong("id"));
        photo.setUrl(rs.getString("url"));
        photo.setIdate(rs.getTimestamp("idate").toLocalDateTime());
        photo.setUdate(rs.getTimestamp("udate").toLocalDateTime());
        photo.setContentType(rs.getString("content_type"));
        return photo;
    }
}
