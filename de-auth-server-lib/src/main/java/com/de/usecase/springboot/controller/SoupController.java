package com.de.usecase.springboot.controller;

import com.de.usecase.springboot.localization.Translator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/de/api/v1")
public class SoupController {

    @Autowired
    private Translator translator;

    @GetMapping("/soup")
    public ResponseEntity<List<String>> getUsers(){
        return new ResponseEntity<>(Arrays.asList(
                translator.toLocale("s1"),
                translator.toLocale("s2"),
                translator.toLocale("s3"),
                translator.toLocale("s4")), HttpStatus.OK);
    }
}
