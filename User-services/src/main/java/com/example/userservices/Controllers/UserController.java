package com.example.userservices.Controllers;

import com.example.userservices.Dto.CredentialsDto;
import com.example.userservices.Dto.LoginDto;
import com.example.userservices.Dto.ResponseDto;
import com.example.userservices.Dto.UserDto;
import com.example.userservices.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/get-all-users")
    public List<UserDto> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/add-user")
    public UserDto addUser(@RequestBody UserDto userDto){
        return userService.addUser(userDto);
    }

    @GetMapping("/{id}")
    public UserDto getOneUser(@PathVariable("id") Long userId){
        return userService.getOneUserById(userId);
    }

    @GetMapping("/cin/{cin}")
    public UserDto getOneUser(@PathVariable("cin") String userCin){
        return userService.getOneUserByCin(userCin);
    }

    @PostMapping("/signIn")
    public ResponseEntity<LoginDto> signIn(@RequestBody CredentialsDto credentialsDto) {
        return ResponseEntity.ok(userService.signIn(credentialsDto));
    }

    @PostMapping("/validateToken")
    public ResponseEntity<LoginDto> signIn(@RequestParam String token) {
        return ResponseEntity.ok(userService.validateToken(token));
    }
}
