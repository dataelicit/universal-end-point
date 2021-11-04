package com.de.usecase.springboot.repository;

import com.de.usecase.springboot.model.ERole;
import com.de.usecase.springboot.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(ERole eRole);
}
