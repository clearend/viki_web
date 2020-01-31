package com.example.viki.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserId(String userId);

    User findByToken(String token);
}
