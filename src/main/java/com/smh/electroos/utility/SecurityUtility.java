package com.smh.electroos.utility;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.Key;
import java.security.SecureRandom;
import java.util.Random;

public class SecurityUtility {

    private static final String KEY = "bigshop";

    @Bean
    public static BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder(14,new SecureRandom(KEY.getBytes()));
    }

    @Bean
    public static  String randomPassword(){
        String KEY_CHAR = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        StringBuilder password = new StringBuilder();
        Random random = new Random();

        while(password.length() < 17){
            int index = (int) (random.nextFloat()*KEY_CHAR.length());

            password.append(KEY_CHAR.charAt(index));
        }

        return password.toString();
    }
}
