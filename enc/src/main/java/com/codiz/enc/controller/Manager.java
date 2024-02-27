package com.codiz.enc.controller;

import com.codiz.enc.Dto.ManageDto;
import com.codiz.enc.models.ManagedObject;
import com.codiz.enc.service.ManagedObjectsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/manager")
public class Manager {
    private final ManagedObjectsService managedObjectsService;

    @PostMapping("manage")
    public ResponseEntity<ManagedObject> manage(@RequestBody ManageDto manageDto){
        log.info("managing request made");
        return ResponseEntity.ok(managedObjectsService.manage(manageDto));
    }
}
