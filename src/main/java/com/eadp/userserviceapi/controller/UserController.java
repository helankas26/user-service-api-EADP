package com.eadp.userserviceapi.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @GetMapping
    public String findAllUsers() {
        return "findAllUsers";
    }

    @PostMapping
    public String createUser() {
        return "createUser";
    }

    @GetMapping
    public String findUser() {
        return "findUser";
    }

    @PutMapping
    public String updateUser() {
        return "updateUser";
    }

    @DeleteMapping
    public String deleteUser() {
        return "deleteUser";
    }
}
