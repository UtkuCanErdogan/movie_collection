package com.erdogan.can.utku.movie.movieservice.repository;

import com.erdogan.can.utku.movie.movieservice.model.Actor;
import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ActorRepository extends JpaRepository<Actor, Long> {

    Optional<List<Actor>> getActorsByName(String name);
}
