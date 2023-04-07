package com.springSecurity.starter.controller;

import com.springSecurity.starter.model.UserModel;
import com.springSecurity.starter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/new")
    public String createUser(@RequestBody UserModel userModel) {
        return userService.createUser(userModel);
    }

}
