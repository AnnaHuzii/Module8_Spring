package com.goitcd5.module8_spring.dao.user;


import java.util.List;
import java.util.UUID;

public interface UserService {

    void saveUser(UserSecurity userSecurity);

    void deleteUser(UUID id);

    User findByEmail(String email);

    List<User> findAll();
    void updateUser(UserSecurity userSecurity, UUID id);

    User findById(UUID id);
}


