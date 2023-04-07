package com.springSecurity.starter.controller;

import com.springSecurity.starter.dto.AuthRequestJWT;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authenticate")
public class JWTController {

    @PostMapping
    public String authenticateAndGetToken(@RequestBody AuthRequestJWT authRequestJWT) {

    }


}
