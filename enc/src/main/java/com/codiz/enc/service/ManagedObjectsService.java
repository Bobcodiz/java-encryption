package com.codiz.enc.service;

import com.codiz.enc.Dto.ManageDto;
import com.codiz.enc.models.ManagedObject;
import com.codiz.enc.repository.ManagedObjectsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ManagedObjectsService {
    private final ManagedObjectsRepository managedRepo;

    public ManagedObject manage(ManageDto manageDto){
        log.info("service to manage objects");
        ManagedObject managedObject = new ManagedObject();
        try{
            managedObject.setPassword(manageDto.getPassword());
            managedObject.setWebsite(manageDto.getWebsite());
            log.info("successful");
            return managedObject;
        }catch (Exception e){
            return null;
        }
    }
}
