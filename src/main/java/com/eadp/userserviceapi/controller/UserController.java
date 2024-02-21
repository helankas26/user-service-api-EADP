package com.eadp.userserviceapi.controller;

import com.eadp.userserviceapi.dto.request.UserRequestDto;
import com.eadp.userserviceapi.service.UserService;
import com.eadp.userserviceapi.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
@CrossOrigin
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(params = {"page", "size", "searchText"})
    public ResponseEntity<StandardResponse> findAllUsers(@RequestParam int page, @RequestParam int size, @RequestParam String searchText) {
        return new ResponseEntity<>(
                new StandardResponse(200, "All User Data", userService.findAllUsers(page, size, searchText)),
                HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<StandardResponse> createUser(@RequestBody UserRequestDto dto) {
        userService.createUser(dto);
        return new ResponseEntity<>(
                new StandardResponse(201, dto.getFullName() + " was Saved!", null),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{userId}")
    public ResponseEntity<StandardResponse> findUser(@PathVariable String userId) {
        return new ResponseEntity<>(
                new StandardResponse(200, "User data", userService.findUser(userId)),
                HttpStatus.OK
        );
    }

    @PutMapping("/{userId}")
    public ResponseEntity<StandardResponse> updateUser(@PathVariable String userId, @RequestBody UserRequestDto dto) {
        userService.updateUser(userId, dto);
        return new ResponseEntity<>(
                new StandardResponse(201, dto.getFullName() + " was updated!", null),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<StandardResponse> deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>(
                new StandardResponse(204, userId + " was Deleted!", null),
                HttpStatus.NO_CONTENT
        );
    }
}
