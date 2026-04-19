package com.ttc.testTaskChat.controller;

import com.ttc.testTaskChat.dto.createRequest.CreateUserRequest;
import com.ttc.testTaskChat.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/add")
    public int createUser(@RequestBody CreateUserRequest createUserRequest){
        return userService.createNewUser(createUserRequest.userName());
    }
}
