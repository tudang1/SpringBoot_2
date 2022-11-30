package com.example.day_17_1118_blog.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpsertUser {
    private String name;

    private String email;

    private String avatar;

    private String password;

    private List<String> roles;
}
