package ColumnEncrypt.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.SerializationUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.util.Base64;

@Configuration
public class AesEncrypter implements AttributeConverter<Object, String> {

    // can be 8, 12 or 16 characters long
    private final String encryptionKey = "kh!f90as-jk5@m27";

//    private final String encryptionCypher = "AES";
    private final String encryptionCypher = "AES";
    private Key key;
    private Cipher cipher;

    private Key getKey() {
        if (key == null) {
            key = new SecretKeySpec(encryptionKey.getBytes(), encryptionCypher);
        }
        return key;
    }

    private Cipher getCipher() throws GeneralSecurityException {
        if (cipher == null) {
            cipher = Cipher.getInstance(encryptionCypher);
        }
        return cipher;
    }

    // encrypt mode maybe encrypt or decrypt
    private void initCipher(int encryptMode) throws GeneralSecurityException {
        getCipher().init(encryptMode, getKey());
    }


    // Encrypter
    @SneakyThrows
    @Override
    public String convertToDatabaseColumn(Object attribute) {
        if (attribute == null) {
            return null;
        }
        String json = new ObjectMapper().writeValueAsString(attribute);
        initCipher(Cipher.ENCRYPT_MODE);
        byte[] encryptedBytes = cipher.doFinal(json.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    // Decrypter
    @SneakyThrows
    @Override
    public Object convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        initCipher(Cipher.DECRYPT_MODE);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(dbData));
        String json = new String(decryptedBytes, StandardCharsets.UTF_8);
        return new ObjectMapper().readValue(json, Object.class);
    }
}
