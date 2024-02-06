package com.eadp.userserviceapi.util;

import java.util.Random;

public class KeyManager {
    private final String CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890_";

    public String generateKey(int length) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(CHARS.charAt(new Random().nextInt(62)));
        }
        return stringBuilder.toString();
    }
}
