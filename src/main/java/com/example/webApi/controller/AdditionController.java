package com.example.webApi.controller;

import com.example.webApi.dto.AdditionRequest;
import com.example.webApi.dto.AdditionRequest2;
import com.example.webApi.dto.AdditionRequest3;
import com.example.webApi.service.AdditionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Validated
public class AdditionController {
    private final AdditionService additionService;

    // AdditionRequest blir validerad explicit med @Valid annotation.
    // Måste göras i alla endpoints där AdditionRequest används, annars blir det säkerhetsproblem.
    @PostMapping("/add")
    public int add(@Valid @RequestBody AdditionRequest additionRequest) {
        return additionService.add(additionRequest.a(), additionRequest.b());
    }

    // AdditionRequest2 valideras alltid i dens constructor. Ingen extra annotation krävs.
    @PostMapping("/add2")
    public int add2(@RequestBody AdditionRequest2 additionRequest) {
        return additionService.add(additionRequest.a(), additionRequest.b());
    }

    // Samma som add2 fast med Lombok
    @PostMapping("/add3")
    public int add2(@RequestBody AdditionRequest3 additionRequest) {
        return additionService.add(additionRequest.a(), additionRequest.b());
    }
}
