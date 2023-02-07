package com.example.gatewayservice.Services.imp;

import com.example.gatewayservice.Dto.ResponseDto;
import com.example.gatewayservice.Dto.TransferDtoToEntity;
import com.example.gatewayservice.Dto.TransferEntityToDto;
import com.example.gatewayservice.Dto.UserDto;
import com.example.gatewayservice.Entities.User;
import com.example.gatewayservice.Repositories.UserRepository;
import com.example.gatewayservice.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseDto addUser(UserDto userDto) {
        User user= TransferDtoToEntity.userDtoToUser(userDto);
        if(user == null || user == new User()){
            return new ResponseDto("Bad request", "L'objet ne doit pas étre null ou vide");
        } else if (user.getCin()=="" || user.getFirstName()=="" || user.getLastName()=="" || user.getPhone()=="" || user.getEmail()=="" || user.getPassword()=="") {
            return new ResponseDto("Bad request", "Toutes les données sont obligatoires");
        }else {
            userRepository.save(user);
            UserDto userDto1= TransferEntityToDto.userToUserDto(user);
            return new ResponseDto("success", "l'utilisateur a été ajouter avec success",userDto1);
        }
    }

    public UserDetails findByEmail(String email){
        User user = userRepository.getUserByEmail(email);
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                Collections.singleton(new SimpleGrantedAuthority("Client")));
    }

    @Override
    public UserDto loadUserByEmail(String email) {
        User user=userRepository.getUserByEmail(email);
        if(user==null){
            throw  new IllegalStateException("L'utilisateur n'existe pas");
        }else{
            UserDto userDto=TransferEntityToDto.userToUserDto(user);
            return userDto;
        }

    }
}
