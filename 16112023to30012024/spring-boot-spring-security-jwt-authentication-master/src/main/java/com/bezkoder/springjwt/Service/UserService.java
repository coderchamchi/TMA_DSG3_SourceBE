package com.bezkoder.springjwt.Service;

import com.bezkoder.springjwt.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> findbyEmail(String email);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    User saveOrupdate(User user);

    boolean existsByPassword(String password);

    User findUserByUserName();

    List<User> getalluser();

}
