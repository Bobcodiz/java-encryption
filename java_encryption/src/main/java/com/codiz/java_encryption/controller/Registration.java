package com.codiz.java_encryption.controller;

import com.codiz.java_encryption.dto.ManagedDto;
import com.codiz.java_encryption.model.ToManaged;
import com.codiz.java_encryption.run.Outcome;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Registration {
    private final Outcome outcome;

    public Registration(Outcome outcome) {
        this.outcome = outcome;
    }

    @PostMapping("/register")
    public ResponseEntity<ToManaged> register(ManagedDto managedDto){
        return ResponseEntity.ok(outcome.register(managedDto));
    }
}
