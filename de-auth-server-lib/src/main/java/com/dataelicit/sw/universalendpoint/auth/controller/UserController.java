package com.dataelicit.sw.universalendpoint.auth.controller;


import com.dataelicit.sw.universalendpoint.auth.dto.JwtOauth2ResponseDto;
import com.dataelicit.sw.universalendpoint.auth.repository.UserRepository;
import com.dataelicit.sw.universalendpoint.auth.service.UserService;
import com.dataelicit.sw.universalendpoint.auth.model.User;
import com.dataelicit.sw.universalendpoint.auth.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("/de/api/v1/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserService userService;

    @PostMapping("/signin")
    public ResponseEntity<JwtOauth2ResponseDto> login(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password) {
        return new ResponseEntity<>(userService.signin(username, password),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userRepository.findAll();

        if (users.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<JwtOauth2ResponseDto> registerUser(@Valid @RequestBody User newUser) {
        newUser.setRoles(new HashSet<>(roleRepository.findAll()));
        return new ResponseEntity<>(userService.signup(newUser),HttpStatus.CREATED);
    }

}

