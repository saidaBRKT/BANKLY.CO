package com.example.gatewayservice.Controllers;

import com.example.gatewayservice.Dto.ResponseDto;
import com.example.gatewayservice.Dto.UserDto;
import com.example.gatewayservice.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/get-all-users")
    public List<UserDto> getAllUsers(){
        return null;
    }

    @PostMapping("add-user")
    public ResponseDto addUser(@RequestBody UserDto userDto){
        return null;
    }

    @PostMapping("/auth/authenticate")
    public ResponseDto authenticate(){
        return null;
    }
}
