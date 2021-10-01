package com.erdogan.can.utku.movie.repository;

import com.erdogan.can.utku.movie.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User getUserByUserName(String userName);
}
