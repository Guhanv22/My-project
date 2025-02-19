package com.example.audible.repository;

import com.example.audible.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer>{
    User findByEmail(String email);
}
