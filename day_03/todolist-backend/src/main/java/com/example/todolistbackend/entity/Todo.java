package com.example.todolistbackend.entity;

import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "todo")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "title")
    private String title;

    // cách 1:
    @Column(name = "status")
    private Boolean status;

    @PrePersist
    public void prePersist() {
        if(status == null) {
            status = false;
        }
    }

    // cách 2:
//    @Column(name = "status")
//    private Boolean status = false;

    // cách 2:
//    @Column(name = "status", columnDefinition = "boolean default false")
//    private Boolean status;
}