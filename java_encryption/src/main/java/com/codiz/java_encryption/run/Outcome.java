package com.codiz.java_encryption.run;

import com.codiz.java_encryption.cryptography.SymmetricKey;
import com.codiz.java_encryption.dto.ManagedDto;
import com.codiz.java_encryption.model.ToManaged;
import com.codiz.java_encryption.repository.ToManage;
import org.springframework.stereotype.Service;

@Service

public class Outcome {

    private final SymmetricKey symmetricKey;
    private final ToManage toManage;

    public Outcome(SymmetricKey symmetricKey, ToManage toManage) {
        this.symmetricKey = symmetricKey;
        this.toManage = toManage;
    }


    public ToManaged register(ManagedDto managedDto) {
        ToManaged toManaged = new ToManaged();
        toManaged.setUsername(managedDto.getUsername());
        toManaged.setPassword(managedDto.getPassword());

        ToManaged user = toManage.save(toManaged);
        return user;
    }
}
