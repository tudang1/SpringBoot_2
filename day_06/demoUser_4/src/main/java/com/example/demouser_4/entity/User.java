package com.example.demouser_4.entity;

import lombok.*;

import javax.persistence.*;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name ="name")
    private String name;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name ="phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "avatar")
    private String avatar;

    @Column(name ="password")
    private String password;

}