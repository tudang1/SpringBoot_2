package com.example.homework_1108.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String userName;

    private String email;

    private String fullName;

    private long phone;

    private String address;

    private boolean inActive;
}
