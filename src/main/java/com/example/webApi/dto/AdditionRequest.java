package com.example.webApi.dto;

import jakarta.validation.constraints.NotNull;

// Validerad med @Valid annotation.
public record AdditionRequest(@NotNull Integer a, @NotNull Integer b) {}


