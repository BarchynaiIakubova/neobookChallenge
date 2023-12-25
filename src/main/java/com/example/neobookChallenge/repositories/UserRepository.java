package com.example.neobookChallenge.repositories;

import com.example.neobookChallenge.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String userName);
}
