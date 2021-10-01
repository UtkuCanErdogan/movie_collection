package com.erdogan.can.utku.movie.repository;

import com.erdogan.can.utku.movie.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long> {
}
