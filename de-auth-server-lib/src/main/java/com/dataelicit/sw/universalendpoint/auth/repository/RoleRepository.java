package com.dataelicit.sw.universalendpoint.auth.repository;

import com.dataelicit.sw.universalendpoint.auth.model.ERole;
import com.dataelicit.sw.universalendpoint.auth.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(ERole eRole);
}
