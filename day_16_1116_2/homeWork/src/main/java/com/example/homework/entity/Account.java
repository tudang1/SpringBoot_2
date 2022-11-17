package com.example.homework.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String password;

    private String fullName;

    private String role;

}
