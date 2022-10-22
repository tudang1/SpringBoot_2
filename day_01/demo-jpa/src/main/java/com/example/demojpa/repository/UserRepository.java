package com.example.demojpa.repository;

import com.example.demojpa.dto.UserDto;
import com.example.demojpa.dto.UserInfo;
import com.example.demojpa.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    // C1 : Sử dụng query method
    List<User> getByNameContainsIgnoreCase(String name);

    boolean existsByEmailIgnoreCase(String email);

    void deleteByEmail(String email);

    User getUserById(Integer id);

    // Trả về trực tiếp ở dạng Dto
    User getUserByEmail(String email);

    // JPQL --> Trả về Dto
    @Query("select new com.example.demojpa.dto.UserDto(u.id, u.name, u.email) from User u where u.email = ?1")
    UserDto getUserDtoByEmail(String email);

    // Projection : Interface --> Trả về Dto
    UserInfo getUserInfoByEmail(String email);

    // Native query --> Trả về Dto
    @Query(nativeQuery = true, name = "getUserDtoByEmailUsingNativeQuery")
    UserDto getUserDtoByEmailUsingNativeQuery(String email);

    // C2 : JPQL : JPA Query Language
    @Query("select u from User u where u.id = ?1")
    User getUserDetailById(Integer id);

    @Query("select u from User u where u.id = :id")
    User getUserDetailByIdOther(@Param("id") Integer id);

    // C3 : Native query
    @Query(nativeQuery = true, value = "select * from user where id = ?1")
    User getUserByIdUsingNativeQuery(Integer id);

    // Thay đổi thông tin user
    @Transactional
    @Modifying
    @Query("update User u set u.name = ?2 where u.id = ?1")
    void updateUserName(Integer id, String name);

    // Sắp xếp
    List<User> getByOrderByAgeAsc();

    @Query(value = "SELECT * FROM user ORDER BY age", nativeQuery = true)
    List<User> getListUserOrderByNameAsc();
}
