package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Table(name = "todo")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "status")
    private Boolean status;
    @PrePersist
    public void prePersist(){
        if (status == null){
            status = false;
        }
    }

}