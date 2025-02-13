package com.example.webApi.dto;

// Alltid validerad i constructorn. Det går inte att göra en AdditionRequest2 med nullvärden.
public record AdditionRequest2(Integer a, Integer b) {
    public AdditionRequest2 {
        if (a == null)
            throw new IllegalArgumentException("a must not be null");
        if (b == null)
            throw new IllegalArgumentException("b must not be null");
    }
}