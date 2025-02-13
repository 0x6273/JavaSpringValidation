package com.example.webApi.controller;

import com.example.webApi.service.CryptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CryptoController {
    @Autowired
    private CryptoService cryptoService;

    @GetMapping("/encrypt")
    public String encrypt(@RequestParam String plainText) {
        return cryptoService.encrypt(plainText) + "\n";
    }

    @GetMapping("/decrypt")
    public String decrypt(@RequestParam String cipherText) {
        return cryptoService.decrypt(cipherText) + "\n";
    }
}
