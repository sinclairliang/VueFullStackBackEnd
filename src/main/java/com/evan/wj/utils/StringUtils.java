package com.evan.wj.utils;

import java.util.Random;

public class StringUtils {
    public static String getRandomString(int length) {
        String SALTCHARS = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            sb.append(SALTCHARS.charAt(random.nextInt(SALTCHARS.length())));
        }
        return sb.toString();
    }
}
