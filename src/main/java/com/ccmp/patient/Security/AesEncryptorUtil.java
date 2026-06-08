package com.ccmp.patient.Security;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AesEncryptorUtil {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/ECB/PKCS5Padding";
    private static final String SECRET_KEY = "MySuperSecretKey16";

    public static String encryption(String data){
        try{
            SecretKeySpec keyspec =  new SecretKeySpec(SECRET_KEY.getBytes(),ALGORITHM);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);
            byte[] encrypted = cipher.doFinal(data.getBytes());
            return Base64.getEncoder().encodeToString(encrypted);
        }
        catch(Exception e){
            throw new RunTimeException("Error encrypting data", e);
        }
    }   

    public static String decrypt(String encryptedData){
        try{
            SecretKeySpec keySpec = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);
            Cipoher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(Cipher.DECRYPT_MODE, keySpec);
            byte[] decoded = Base64.getDecoder().decode(encryptedData);
            byte[] decrypted = cipher.doFinal(decoded);
            return new String(decrypted);
        }
        catch(Exception e){
            throw new RunTimeException("Error decrypting data", e);
            
        }
    }
    
    
}
