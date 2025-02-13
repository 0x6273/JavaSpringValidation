package com.example.webApi.dto;

import lombok.NonNull;

// Alltid validerad i constructorn. Det går inte att göra en AdditionRequest3 med nullvärden.
// Skillnaden från AdditionRequest2 e att den använder Lombok's @NonNull som gör en automatisk constructor.
public record AdditionRequest3(@NonNull Integer a, @NonNull Integer b) {}