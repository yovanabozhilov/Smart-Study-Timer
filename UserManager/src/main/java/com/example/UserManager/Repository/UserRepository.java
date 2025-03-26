package com.example.UserManager.Repository;

import com.example.UserManager.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    Optional<User>findOneByEmailAndPassword(String username,String password);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}