package az.product.security;

import az.product.model.db.Role;
import az.product.model.db.User;
import az.product.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductManagementUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserPrincipal userPrincipal = null;
        Optional<User> optionalUser = userService.getUserByEmail(email);
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            List<Role> roles = userService.getUserRoles(user.getId());
            user.setRoleList(roles);
            userPrincipal = new UserPrincipal(user);
        }else {
            throw new UsernameNotFoundException("User " + email + " not found!");
        }
        return userPrincipal;
    }

}
