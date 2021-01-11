package az.product.repository.rowmapper;

import az.product.model.db.Role;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class RoleRowMapper implements RowMapper<Role> {


    @Override
    public Role mapRow(ResultSet rs, int i) throws SQLException {
        Role role = Role.fromValue(rs.getLong("id"));
        role.setSuccessPage(rs.getString("success_page"));
        role.setRoleName(rs.getString("role_name"));
        return role;
    }
}
