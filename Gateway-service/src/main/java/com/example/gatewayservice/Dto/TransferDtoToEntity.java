package com.example.gatewayservice.Dto;

import com.example.gatewayservice.Entities.User;
import org.modelmapper.ModelMapper;

public class TransferDtoToEntity {

    public static User userDtoToUser(UserDto userDto) {
        ModelMapper modelMapper=new ModelMapper();
        return modelMapper.map(userDto,User.class);
    }
}
