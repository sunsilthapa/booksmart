package  com.example.bookmarts.service;

import  com.example.bookmarts.entity.User;

import java.util.List;

public interface UserService {
    void save(User user);
    void login(String username, String password);
    User findByUsername(String username);
    User findByEmail(String email);
    User findById(long id);
    void deleteById(Integer id);

    List<User> findAllUser();
}
