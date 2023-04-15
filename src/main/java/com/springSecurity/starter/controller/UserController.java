package com.springSecurity.starter.controller;

import com.springSecurity.starter.model.UserModel;
import com.springSecurity.starter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/new")
    public String createUser(@RequestBody UserModel userModel) {
        return userService.createUser(userModel);
    }

}
