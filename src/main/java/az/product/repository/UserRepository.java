package az.product.repository;

import az.product.model.db.Role;
import az.product.model.db.User;
import az.product.model.db.UserRole;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    void addUser(User user);

    Optional<User> getUserByEmail(String email);

    List<Role> getUserRoles(long id);

    void addUserRole(UserRole userRole);

    boolean isEmailExist(String value);


}
