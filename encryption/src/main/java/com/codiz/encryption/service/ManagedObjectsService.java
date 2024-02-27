package com.codiz.encryption.service;

import com.codiz.encryption.models.ManagedObjects;
import com.codiz.encryption.repository.ManagedObjectsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ManagedObjectsService {
    private final ManagedObjectsRepository managedRepository;

    public ManagedObjects encryptionManager(){

    }
}
