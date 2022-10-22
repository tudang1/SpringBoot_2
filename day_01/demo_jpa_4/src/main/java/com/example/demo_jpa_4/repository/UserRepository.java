package com.example.demo_jpa_4.repository;


import com.example.demo_jpa_4.dto.UserDto;
import com.example.demo_jpa_4.dto.UserInfo;
import com.example.demo_jpa_4.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

    //c1: sử dụng query method
    List<User> getByNameContainsIgnoreCase(String name);
    boolean existsByEmailIgnoreCase(String email);

    void deleteByEmail(String email);

    User getUserById(Integer id);

    User getUserByEmail(String email);
    // JPQL -> tra ve DTo
    @Query("select new com.example.demo_jpa_4.dto.UserDto(u.id,u.name,u.email) from User u where u.email = ?1")
    UserDto getUserDtoByEmail(String email);

    //Projection: Interface -> tra ve Dto

    //native Query
    @Query(nativeQuery = true,name = "getUserDtoEmailUsingNativeQuery")
    UserDto getUserDtoEmailUsingNativeQuery(String email);

    //c2: JPQL: JPA query language
    @Query("SELECT u from User u where u.id = ?1")
    User getUserDetailById(Integer id);

    @Query("SELECT u from User u where u.id = id")
    User getUserDetailByIdOther(@Param("id") Integer id);

    //c3: Native query
    @Query(nativeQuery = true,value = "select * form user where id = ?1")
    User getUserByIdUsingNativeQuery(Integer id);
    //thay doi thong tin
    @Transactional
    @Modifying
    @Query("update User u set u.name = ?2 where u.id = ?1")
    void updateUserName(Integer id, String name);

    List<User> findByAge(Integer age);

    //sap xep
    List<User> getByOrderByAgeAsc();

    List<User> getByOrderByAgeDesc();

}
