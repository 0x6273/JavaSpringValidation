package com.example.webApi.service;

import org.springframework.stereotype.Service;

@Service
public class CryptoService {
    public String encrypt(String plainText) {
        return rot13(plainText);
    }

    public String decrypt(String cipherText) {
        return rot13(cipherText);
    }

    public static String rot13(String input) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if       (c >= 'a' && c <= 'm') c += 13;
            else if  (c >= 'A' && c <= 'M') c += 13;
            else if  (c >= 'n' && c <= 'z') c -= 13;
            else if  (c >= 'N' && c <= 'Z') c -= 13;
            sb.append(c);
        }
        return sb.toString();
    }
}
