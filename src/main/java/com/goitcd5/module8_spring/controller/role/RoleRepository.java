package com.goitcd5.module8_spring.controller.role;

import com.goitcd5.module8_spring.dao.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
        Optional<Role> findByName(String name);
}
