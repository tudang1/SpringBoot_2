package com.example.userbackend.repository;

import com.example.userbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Transactional
    @Modifying
    @Query("update User u set u.avatar = ?2 where u.id = ?1") // JPQL
    void updateAvatar(Integer id, String avatarUrl);

    List<User> findByNameContainsIgnoreCase(String name);

    Optional<User> findByEmail(String email);
}