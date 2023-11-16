package com.bezkoder.springjwt.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bezkoder.springjwt.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);

  Optional<User> findByEmail(String email);

  Boolean existsByPassword(String password);

  User findUserByUsername(String username);

}
