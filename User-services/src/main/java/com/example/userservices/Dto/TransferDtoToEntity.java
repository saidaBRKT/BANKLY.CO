package com.example.userservices.Dto;

import com.example.userservices.Entities.User;
import org.modelmapper.ModelMapper;

public class TransferDtoToEntity {

    public static User userDtoToUser(UserDto userDto) {
        ModelMapper modelMapper=new ModelMapper();
        return modelMapper.map(userDto,User.class);
    }
}
