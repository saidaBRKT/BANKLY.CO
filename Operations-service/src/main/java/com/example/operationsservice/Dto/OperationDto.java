package com.example.operationsservice.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OperationDto implements Serializable {
    private Long id;
    private String cin;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String password;

    public OperationDto(String cin, String firstName, String lastName, String phone, String email, String password) {
        this.cin = cin;
        this.firstName=firstName;
        this.lastName=lastName;
        this.phone=phone;
        this.email = email;
        this.password = password;
    }
}
