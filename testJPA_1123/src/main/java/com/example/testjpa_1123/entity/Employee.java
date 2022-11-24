package com.example.testjpa_1123.entity;

import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "employee")
@NamedQuery(name = "Employee.fetchByLastName",
        query = "SELECT e.lastName FROM Employee e "
)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String emailAddress;

    private String firstName;

    private String lastName;
}