package io.spring.springboot.Service;

import io.spring.springboot.Entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
     void addUser(User user);
     User getUserId(long id);

     User findByUsername(String username);

     void deleteUserById(long id);

    UserDetails userDetails(String username) throws UsernameNotFoundException;
}
