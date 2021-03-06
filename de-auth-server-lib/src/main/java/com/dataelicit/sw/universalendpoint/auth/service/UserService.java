package com.dataelicit.sw.universalendpoint.auth.service;


import javax.servlet.http.HttpServletRequest;

import com.dataelicit.sw.universalendpoint.auth.dto.JwtOauth2ResponseDto;
import com.dataelicit.sw.universalendpoint.auth.exception.CustomWebException;
import com.dataelicit.sw.universalendpoint.auth.model.Role;
import com.dataelicit.sw.universalendpoint.auth.model.User;
import com.dataelicit.sw.universalendpoint.auth.repository.UserRepository;
import com.dataelicit.sw.universalendpoint.auth.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    public JwtOauth2ResponseDto signin(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            final String accessToken = jwtTokenProvider.createToken(username, userRepository.findByUsername(username).get().getRoles().stream().map(Role::getName).collect(Collectors.toSet()));
            return new JwtOauth2ResponseDto(accessToken,"");
        } catch (AuthenticationException e) {
            throw new CustomWebException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public JwtOauth2ResponseDto signup(User appUser) {
        if (!userRepository.existsByUsername(appUser.getUsername())) {
            appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
            userRepository.save(appUser);
            final String accessToken =jwtTokenProvider.createToken(appUser.getUsername(), appUser.getRoles().stream().map(Role::getName).collect(Collectors.toSet()));
            return new JwtOauth2ResponseDto(accessToken,"");
        } else {
            throw new CustomWebException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public void delete(String username) {
        userRepository.deleteUserByUsername(username);
    }

    public User search(String username) {
        Optional<User> appUser = userRepository.findByUsername(username);
        if (!appUser.isPresent()) {
            throw new CustomWebException("The user doesn't exist", HttpStatus.NOT_FOUND);
        }
        return appUser.get();
    }

    public User whoami(HttpServletRequest req) {
        return userRepository.findByUsername(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(req))).get();
    }

    public String refresh(String username) {
        return jwtTokenProvider.createToken(username, userRepository.findByUsername(username).get().getRoles().stream().map(Role::getName).collect(Collectors.toSet()));
    }

}

