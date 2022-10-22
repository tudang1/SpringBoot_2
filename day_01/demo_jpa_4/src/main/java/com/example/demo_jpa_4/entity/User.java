package com.example.demo_jpa_4.entity;

import com.example.demo_jpa_4.dto.UserDto;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@NamedNativeQuery(
        name = "getUserDtoEmailUsingNativeQuery",
        query = "select u.id, u.name, u.email from user u where u.email = ?1",
        resultSetMapping = "userInfo"
)
@SqlResultSetMapping(
        name = "userInfo",
        classes = @ConstructorResult(
                targetClass = UserDto.class,
                columns = {
                        @ColumnResult(name = "id"),
                        @ColumnResult(name = "name"),
                        @ColumnResult(name = "email")
                }
        )
)
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "age")
    private Integer age;

    @Column(name = "birth")
    private LocalDate birth;

    @PrePersist
    public void prePersist() {
        birth = LocalDate.now().minusYears(age);
    }
}
