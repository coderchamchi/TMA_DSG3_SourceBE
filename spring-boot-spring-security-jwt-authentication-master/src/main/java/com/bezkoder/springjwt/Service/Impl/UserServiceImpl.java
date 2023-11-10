package com.bezkoder.springjwt.Service.Impl;

import com.bezkoder.springjwt.constant.WebUnit;
import com.bezkoder.springjwt.entities.User;
import com.bezkoder.springjwt.Service.UserService;
import com.bezkoder.springjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> findbyEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }
    @Override
    public boolean existsByPassword(String password) {
        return userRepository.existsByPassword(password);
    }
    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public User saveOrupdate(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUserByUserName() {
        return userRepository.findUserByUsername(WebUnit.getUsername());
    }

    @Override
    public List<User> getalluser(){
        return userRepository.findAll();
    }
}

