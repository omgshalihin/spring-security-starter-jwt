package com.springSecurity.starter.dto;

public record AuthRequestJWT(
        String username,
        String password
) {
}
