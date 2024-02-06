package com.eadp.userserviceapi.controller;

import com.eadp.userserviceapi.dto.request.RequestUserDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @GetMapping(params = {"page", "size", "searchText"})
    public String findAllUsers(@RequestParam int page, @RequestParam int size, @RequestParam String searchText) {
        return "findAllUsers";
    }

    @PostMapping
    public String createUser(@RequestBody RequestUserDto dto) {
        return dto.toString();
    }

    @GetMapping("/{id}")
    public String findUser(@PathVariable String id) {
        return "findUser";
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable String id, @RequestBody RequestUserDto dto) {
        return "updateUser";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable String id) {
        return "deleteUser";
    }
}
