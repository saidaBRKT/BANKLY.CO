package com.example.userservices.Dto;

import lombok.*;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {
    private Long id;
    private String cin;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String password;

    public UserDto(String cin, String firstName, String lastName, String phone, String email, String password) {
        this.cin = cin;
        this.firstName=firstName;
        this.lastName=lastName;
        this.phone=phone;
        this.email = email;
        this.password = password;
    }
}
