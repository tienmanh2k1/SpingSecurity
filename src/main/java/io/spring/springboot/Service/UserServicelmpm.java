package io.spring.springboot.Service;

import io.spring.springboot.Entity.User;
import io.spring.springboot.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServicelmpm implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUser() {

        return userRepository.findAll();
    }

    @Override
    public void addUser(User user) {
        this.userRepository.save(user);
    }

    @Override
    public User getUserId(long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        User user = null;
        if (optionalUser.isPresent()){
            user = optionalUser.get();
        }else {
            throw new RuntimeException("Not found id : "+ id);
        }
        return user;
    }

    @Override
    public User findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("User not found");
        }
        return null;
    }

    @Override
    public void deleteUserById(long id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public UserDetails userDetails(String username) throws UsernameNotFoundException {
        return null;
    }


}
