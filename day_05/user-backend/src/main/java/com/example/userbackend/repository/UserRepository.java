package com.example.userbackend.repository;

import com.example.userbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Transactional
    @Modifying
    @Query("update User u set u.avatar = ?2 where u.id = ?1") //JPQL
    void updateAvatar(Integer id, String avatarUrl);
}