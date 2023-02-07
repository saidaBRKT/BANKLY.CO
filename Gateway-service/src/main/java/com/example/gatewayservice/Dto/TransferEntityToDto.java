package com.example.gatewayservice.Dto;

import com.example.gatewayservice.Entities.User;
import org.modelmapper.ModelMapper;

public class TransferEntityToDto {
    public static UserDto userToUserDto(User user) {
        ModelMapper modelMapper=new ModelMapper();
        return modelMapper.map(user,UserDto.class);
    }
}
