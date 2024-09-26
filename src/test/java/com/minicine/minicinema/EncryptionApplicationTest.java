package com.minicine.minicinema;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import com.minicine.minicinema.config.JasyptConfig;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.jupiter.api.Test;

public class EncryptionApplicationTest extends JasyptConfig {

    @Test
    public void jasyptEncDec() {
        // given
        String url= "jdbc:mysql://minicinema.chckqcu2wxzm.ap-northeast-2.rds.amazonaws.com:3306/minicinemaDB";
        String userName = "minicine";
        String password = "minicine2024!";
        String jwtTokenKey = "QkFBQ0RFRkdISUpLTE1OT1BRUlNUVVZXWFlaQUJDREVGR0hJSktMTU5PUFFSU1RVVldYWVo=";

        // when
        String encryptedURL = jasyptEncrypt(url);
        String encrypteduserName = jasyptEncrypt(userName);
        String encryptedPw = jasyptEncrypt(password);
        String encryptedJwtTokenKey = jasyptEncrypt(jwtTokenKey);

        System.out.println("DB URL 암호화 된 값 :::: " + encryptedURL);
        System.out.println("DB userName 암호화 된 값 :::: " + encrypteduserName);
        System.out.println("DB userPW 암호화 된 값 :::: " + encryptedPw);
        System.out.println("jwt token key 암호화 된 값 :::: " + encryptedJwtTokenKey);

        System.out.println("url 복호화 :::::::: " + jasyptDecrypt(encryptedURL));
        System.out.println("name 복호화 :::::::: " + jasyptDecrypt(encrypteduserName));
        System.out.println("pw 복호화 :::::::: " + jasyptDecrypt(encryptedPw));
        System.out.println("jwt 복호화 :::::::: " + jasyptDecrypt(encryptedJwtTokenKey));

        // then
        assertThat(url).isEqualTo(jasyptDecrypt(encryptedURL));
        assertThat(userName).isEqualTo(jasyptDecrypt(encrypteduserName));
        assertThat(password).isEqualTo(jasyptDecrypt(encryptedPw));
        assertThat(jwtTokenKey).isEqualTo(jasyptDecrypt(encryptedJwtTokenKey));

    }

    private String jasyptEncrypt(String input) { // 암호화
        String key = "minicine2024";
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setAlgorithm("PBEWithMD5AndDES");
        encryptor.setPassword(key);
        return encryptor.encrypt(input);
    }

    private String jasyptDecrypt(String input){ // 복호화
        String key = "minicine2024";
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setAlgorithm("PBEWithMD5AndDES");
        encryptor.setPassword(key);
        return encryptor.decrypt(input);
    }
}
