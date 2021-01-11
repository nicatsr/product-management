package az.product.repository.impl;

import az.product.model.db.Role;
import az.product.model.db.User;
import az.product.model.db.UserRole;
import az.product.repository.UserRepository;
import az.product.repository.query.UserQuery;
import az.product.repository.rowmapper.RoleRowMapper;
import az.product.repository.rowmapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.filter.OncePerRequestFilter;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private UserRowMapper userRowMapper;

    @Override
    public void addUser(User user) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("full_name" , user.getFullName());
        parameterSource.addValue("email" , user.getEmail());
        parameterSource.addValue("password" , user.getPassword());
        parameterSource.addValue("idate" ,user.getIdate());
        parameterSource.addValue("udate" , user.getUdate());

        int count =
                namedParameterJdbcTemplate.update(UserQuery.INSERT_USER ,parameterSource);
        if (count < 1){
            throw new RuntimeException("error adding user ");
        }
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        Optional<User> optionalUser = Optional.empty();
        Object[] args = new Object[]{email};
        List<User> list =
                jdbcTemplate.query(UserQuery.GET_USER_BY_EMAIL ,userRowMapper ,args);
        if (!list.isEmpty()){
            optionalUser = Optional.of(list.get(0));
        }
        return optionalUser;
    }

    @Autowired
    private RoleRowMapper roleRowMapper;

    @Override
    public List<Role> getUserRoles(long id) {
        Object[] args = {id};
        return jdbcTemplate.query(UserQuery.GET_USER_ROLES ,roleRowMapper ,args);
    }


    @Override
    public void addUserRole(UserRole userRole) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("role_id" , userRole.getRoleId());
        parameterSource.addValue("user_id" , userRole.getUserId());

        int count  =
                namedParameterJdbcTemplate.update(UserQuery.INSERT_USER_ROLE, parameterSource);
        if (count < 1){
            throw new RuntimeException("error adding user role");
        }
    }

    @Override
    public boolean isEmailExist(String value) {
        boolean isEmailExits = false;
        MapSqlParameterSource parameterSource = new MapSqlParameterSource("email" , value);
        int count =
                namedParameterJdbcTemplate.queryForObject(UserQuery.IS_EMAIL_EXISTS , parameterSource , Integer.class);
        if (count > 0){
            isEmailExits = true;
        }

        return isEmailExits;
    }
}
