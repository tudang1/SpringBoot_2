package com.example.demojpa.dto;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Integer id;
    private String name;
    private String email;
}

// c1 : Query User => Convert to Dto
// Convert tự viết
// Sử dụng dependence (mapstruct, modelMapper, ...)

// c2 : Sử dụng JPA query language
// c3 : Sử dụng Projection
// c4 : Sử dụng native query
