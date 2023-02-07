package com.example.gatewayservice.Services;

import com.example.gatewayservice.Dto.ResponseDto;
import com.example.gatewayservice.Dto.UserDto;

public interface UserService {
    ResponseDto addUser(UserDto userDto);
    UserDto loadUserByEmail(String email);
}
