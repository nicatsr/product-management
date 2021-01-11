package az.product.service;

import az.product.model.db.Role;
import az.product.model.db.User;
import az.product.model.db.UserRole;
import az.product.model.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void addUser(UserDto userDto);

    Optional<User> getUserByEmail(String email);

    List<Role> getUserRoles(long id);

    void addUserRole(UserRole userRole);

    boolean isEmailExist(String value);
}
