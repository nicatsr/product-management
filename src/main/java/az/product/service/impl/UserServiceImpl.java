package az.product.service.impl;

import az.product.model.db.Role;
import az.product.model.db.User;
import az.product.model.db.UserRole;
import az.product.model.dto.UserDto;
import az.product.repository.UserRepository;
import az.product.service.PasswordService;
import az.product.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordService passwordService;

    @Transactional
    @Override
    public void addUser(UserDto userDto) {
        User user = new User();
        user.setFullName(userDto.getFullName());
        user.setEmail(userDto.getEmail());

        String hashedPassword = passwordService.hashPassword(userDto.getPassword());
        user.setPassword(hashedPassword);

        user.setIdate(LocalDateTime.now());
        user.setUdate(LocalDateTime.now());
        userRepository.addUser(user);

        Optional<User> optionalUserFromDb = getUserByEmail(user.getEmail());
        User userFromDb = null;
        UserRole userRole = new UserRole();
        if (optionalUserFromDb.isPresent()){
            userFromDb = optionalUserFromDb.get();
            userRole.setUserId(userFromDb.getId());
        }
        userRole.setRoleId(Role.ADMIN.getId());
        addUserRole(userRole);

    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    @Override
    public List<Role> getUserRoles(long id) {
        return userRepository.getUserRoles(id);
    }

    @Override
    public void addUserRole(UserRole userRole) {
        userRepository.addUserRole(userRole);
    }

    @Override
    public boolean isEmailExist(String value) {
        return userRepository.isEmailExist(value);
    }
}
