package com.erdogan.can.utku.movie.userservice.repository;

import com.erdogan.can.utku.movie.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> getUserByUsername(String username);
}
