package com.example.demo_jpa_4.dto;

import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Integer id;
    private String name;
    private String email;
}

//c1: Query User => convert to DTo
//convert tự viết
//sử dụng dependence(mapstruct, model Mapper,..)

//c2: sử dụng JPA query language
//c3: sử dụng projection
//c4: sử dụng native query
