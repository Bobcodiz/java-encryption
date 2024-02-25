package com.codiz.java_encryption.run;

import com.codiz.java_encryption.cryptography.SymmetricKey;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class Outcome {

    private SymmetricKey symmetricKey;



}
