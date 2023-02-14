package com.example.userservices.Services.imp;

import com.example.userservices.Dto.*;
import com.example.userservices.Entities.User;
import com.example.userservices.Repositories.UserRepository;
import com.example.userservices.Services.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    private String secretKey = "secret";

//    @Override
//    public ResponseDto addUser(UserDto userDto) {
//        User user= TransferDtoToEntity.userDtoToUser(userDto);
//        if(user == null || user == new User()){
//            return new ResponseDto("Bad request", "L'objet ne doit pas étre null ou vide");
//        } else if (user.getCin()=="" || user.getFirstName()=="" || user.getLastName()=="" || user.getPhone()=="" || user.getEmail()=="" || user.getPassword()=="") {
//            return new ResponseDto("Bad request", "Toutes les données sont obligatoires");
//        }else {
//            userRepository.save(user);
//            UserDto userDto1= TransferEntityToDto.userToUserDto(user);
//            return new ResponseDto("success", "l'utilisateur a été ajouter avec success",userDto1);
//        }
//    }

//    public UserDetails findByEmail(String email){
//        User user = userRepository.getUserByEmail(email);
//        return new org.springframework.security.core.userdetails.User(
//                user.getEmail(),
//                user.getPassword(),
//                Collections.singleton(new SimpleGrantedAuthority("Client")));
//    }

    @Override
    public UserDto addUser(UserDto userDto) {
        User user= TransferDtoToEntity.userDtoToUser(userDto);
        UserDto userDto1= TransferEntityToDto.userToUserDto(userRepository.save(user));
        return userDto1;
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

    @Override
    public UserDto getOneUserById(Long userId) {
        return TransferEntityToDto.userToUserDto(userRepository.findUserById(userId));
    }

    @Override
    public UserDto getOneUserByCin(String userCin) {
        User user = userRepository.findByCin(userCin);
        System.out.println("user ======"+user.getCin());
        return TransferEntityToDto.userToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(u->TransferEntityToDto.userToUserDto(u)).collect(Collectors.toList());
    }

    @Override
    public LoginDto signIn(CredentialsDto credentialsDto) {
        User user = userRepository.findByEmail(credentialsDto.getEmail());
        LoginDto loginDto=new LoginDto();
        if(user==null || user==new User()){
            throw new IllegalStateException("l'utilisateur n'exist pas");
            //return new ResponseDto("Error","l'utilisateur n'exist pas");
        }
//        else if (passwordEncoder.matches(CharBuffer.wrap(loginDto.getPassword()), user.getPassword())) {
        else if(credentialsDto.getEmail().equals(user.getEmail()) && credentialsDto.getPassword().equals(user.getPassword())){
            loginDto.setEmail(credentialsDto.getEmail());
            loginDto.setPassword(credentialsDto.getPassword());
            loginDto.setToken(createToken(user));
            return loginDto;
            //return new ResponseDto("success","sign in with success",createToken(user));
        }else {
            throw new IllegalStateException("Password non valid");
            //return new ResponseDto("Error","Password non valid");
        }
    }

    private String createToken(User user) {
        Claims claims = Jwts.claims().setSubject(user.getEmail());

        Date now = new Date();
        Date validity = new Date(now.getTime() + 3600000);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

//    @Override
//    public ResponseDto validateToken(String token) {
//        String email = Jwts.parser()
//                .setSigningKey(secretKey)
//                .parseClaimsJws(token)
//                .getBody()
//                .getSubject();
//        User user = userRepository.findByEmail(email);
//
//        if (user==null || user==new User()) {
//            return new ResponseDto("Error","user is null or empty");
//        }
//
//        return new ResponseDto("success","Token is valid",createToken(user));
//    }

    @Override
    public LoginDto validateToken(String token) {
        String email = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
        User user = userRepository.findByEmail(email);

        if (user==null || user==new User()) {
            throw new IllegalStateException("user cannot be null or empty");
        }

        return new LoginDto(user.getEmail(), user.getPassword(), createToken(user));
    }


}
