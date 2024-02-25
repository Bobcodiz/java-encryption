package com.codiz.java_encryption.controller;

import com.codiz.java_encryption.dto.ManagedDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Registration {
    @PostMapping("/register")
    public ResponseEntity<String> register(ManagedDto managedDto){

    }
}
