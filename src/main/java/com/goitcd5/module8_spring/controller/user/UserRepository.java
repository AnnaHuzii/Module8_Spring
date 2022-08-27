package com.goitcd5.module8_spring.controller.user;

import com.goitcd5.module8_spring.dao.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;


public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String name);

}
