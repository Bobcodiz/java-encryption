package com.codiz.enc.service;

import com.codiz.enc.Dto.ManageDto;
import com.codiz.enc.encryption.DecryptionUtils;
import com.codiz.enc.encryption.EncryptionKeysUtils;
import com.codiz.enc.encryption.EncryptionUtils;
import com.codiz.enc.models.ManagedObject;
import com.codiz.enc.repository.ManagedObjectsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ManagedObjectsService {
    private final ManagedObjectsRepository managedRepo;
    private final EncryptionUtils encryptionUtils;
    private final DecryptionUtils decryptionUtils;
    private final EncryptionKeysUtils encryptionKeysUtils;
    private SecretKey secretKey;
    private IvParameterSpec iv;


    public ManagedObject manage(ManageDto manageDto){
        log.info("service to manage objects");
        ManagedObject managedObject = new ManagedObject();
        try{
            secretKey = encryptionKeysUtils.generateSecretKey();
            iv = encryptionKeysUtils.ivKey();
            log.info("keys generation success");
            log.info("the secret key is {} and the iv is {}",secretKey,iv);
            managedObject.setPassword(encryptionUtils.encrypt(manageDto.getPassword(),secretKey,iv));
            managedObject.setWebsite(encryptionUtils.encrypt(manageDto.getWebsite(),secretKey,iv));
            log.info("successful");
            return managedRepo.save(managedObject);
        }catch (Exception e){
            return null;
        }
    }
    public String decrypted(Long id){
        log.info("decryption service");
        try {
            new ManagedObject();
            Optional<ManagedObject> object;
            object = managedRepo.findById(id);
            return decryptionUtils.decrypt(String.valueOf(object),secretKey,iv);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
