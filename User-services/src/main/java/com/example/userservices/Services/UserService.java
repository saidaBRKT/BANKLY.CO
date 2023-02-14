package com.example.userservices.Services;

import com.example.userservices.Dto.CredentialsDto;
import com.example.userservices.Dto.LoginDto;
import com.example.userservices.Dto.ResponseDto;
import com.example.userservices.Dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto addUser(UserDto userDto);
    UserDto loadUserByEmail(String email);

    UserDto getOneUserById(Long userId);

    UserDto getOneUserByCin(String userCin);

    List<UserDto> getAllUsers();

    LoginDto signIn(CredentialsDto credentialsDto);

    LoginDto validateToken(String token);
}
