package com.erdogan.can.utku.movie.movieservice.controller;

import com.erdogan.can.utku.movie.movieservice.dto.request.CreateActorRequest;
import com.erdogan.can.utku.movie.movieservice.dto.request.UpdateActorRequest;
import com.erdogan.can.utku.movie.movieservice.dto.response.ActorDto;
import com.erdogan.can.utku.movie.movieservice.dto.response.ActorMovieDto;
import com.erdogan.can.utku.movie.movieservice.model.Movie;
import com.erdogan.can.utku.movie.movieservice.service.ActorServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actor")
public class ActorController {

    private final ActorServiceImpl service;

    public ActorController(ActorServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActorDto> getActorById(@PathVariable long id){
        return ResponseEntity.ok(service.getActorById(id));
    }

    @GetMapping("/get{id}")
    public ResponseEntity<ActorMovieDto> getActorMovieById(@PathVariable long id){
        return ResponseEntity.ok(service.getActorMovieById(id));
    }

    @GetMapping("/getactors")
    public ResponseEntity<List<ActorDto>> getAllActors(){
        return ResponseEntity.ok(service.getAllActors());
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<List<ActorDto>> getActorsByName(@PathVariable String name){
        return ResponseEntity.ok(service.getActorsByName(name));
    }

    @PostMapping("/create")
    public ResponseEntity<ActorDto> createActor(@RequestBody CreateActorRequest request){
        return ResponseEntity.ok(service.createActor(request));
    }

    @PostMapping("/{id}/addmovie")
    public ResponseEntity<Void> addMovie(@RequestBody Movie movie, @PathVariable long id){
        service.addMovie(movie, id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/addmovies")
    public ResponseEntity<Void> addMovies(@RequestBody List<Movie> list, @PathVariable long id){
        service.addMovies(list, id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ActorMovieDto> updateActor(@RequestBody UpdateActorRequest request, @PathVariable long id){
        return ResponseEntity.ok(service.updateActor(request, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteActor(@PathVariable long id){
        service.deleteActorById(id);
        return ResponseEntity.ok().build();
    }


}
