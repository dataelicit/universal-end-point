package com.de.universalendpoint.auth.repository;

import com.de.universalendpoint.auth.model.ERole;
import com.de.universalendpoint.auth.model.Role;
import com.de.universalendpoint.auth.model.ERole;
import com.de.universalendpoint.auth.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(ERole eRole);
}
