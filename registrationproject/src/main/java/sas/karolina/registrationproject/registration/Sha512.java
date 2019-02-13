package sas.karolina.registrationproject.registration;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sha512 {

    public static String hash(final String passwordToHash) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] hashedPasswordInBytes = md.digest(passwordToHash.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< hashedPasswordInBytes.length ;i++){
            sb.append(Integer.toString((hashedPasswordInBytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        String hashedPasswordInString = sb.toString();
        return hashedPasswordInString;
    }

}

