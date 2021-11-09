package com.dataelicit.sw.universalendpoint.auth.repository;

import com.dataelicit.sw.universalendpoint.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    @Transactional
    Boolean deleteUserByUsername(String username);

}
