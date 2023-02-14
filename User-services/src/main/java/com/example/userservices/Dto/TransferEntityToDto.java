package com.example.userservices.Dto;

import com.example.userservices.Entities.User;
import org.modelmapper.ModelMapper;

public class TransferEntityToDto {
    public static UserDto userToUserDto(User user) {
        ModelMapper modelMapper=new ModelMapper();
        return modelMapper.map(user, UserDto.class);
    }
}
