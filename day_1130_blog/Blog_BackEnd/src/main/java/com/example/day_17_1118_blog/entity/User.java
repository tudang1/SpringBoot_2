package com.example.day_17_1118_blog.entity;

import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
@TypeDef(
        name = "json",
        typeClass = JsonStringType.class
)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "password")
    private String password;


    @Type(type = "json")
    @Column(name = "roles", columnDefinition = "json")
    private List<String> roles;
}