package com.example.demouser_4.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UpdateInfoUser {
    private String name;
    private String email;
    private String phone;
    private String address;
    private String oldPassword;
    private String newPassword;
}
