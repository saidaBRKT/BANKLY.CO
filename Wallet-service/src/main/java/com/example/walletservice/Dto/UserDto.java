package com.example.walletservice.Dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String cin;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String password;
}
