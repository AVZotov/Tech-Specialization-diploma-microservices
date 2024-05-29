package ru.gb.domain;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email
) { }
