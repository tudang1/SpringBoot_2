package com.example.homework_1108.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String userName;

    private String password;

    private String fullName;

}
