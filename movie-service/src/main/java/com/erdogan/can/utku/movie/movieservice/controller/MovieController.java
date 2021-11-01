package com.erdogan.can.utku.movie.movieservice.controller;

import com.erdogan.can.utku.movie.movieservice.dto.request.CreateMovieRequest;
import com.erdogan.can.utku.movie.movieservice.dto.request.UpdateMovieRequest;
import com.erdogan.can.utku.movie.movieservice.dto.response.MovieDto;
import com.erdogan.can.utku.movie.movieservice.model.Actor;
import com.erdogan.can.utku.movie.movieservice.service.MovieServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private final MovieServiceImpl service;

    public MovieController(MovieServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getMovieById(@PathVariable long id){
        return ResponseEntity.ok(service.getMovieById(id));
    }

    @GetMapping("/movies")
    public ResponseEntity<List<MovieDto>> getAllMovies(){
        return ResponseEntity.ok(service.getAllMovies());
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<List<MovieDto>> getMoviesByName(@PathVariable String name){
        return ResponseEntity.ok(service.getMoviesByName(name));
    }

    @PostMapping("/create")
    public ResponseEntity<MovieDto> createMovie(@RequestBody CreateMovieRequest request){
        return ResponseEntity.ok(service.createMovie(request));
    }

    @PostMapping("/addactors")
    public ResponseEntity<Void> addActors(@PathVariable long id, @RequestBody List<Actor> actors){
        service.addActors(id, actors);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MovieDto> updateMovie(@RequestBody UpdateMovieRequest request, @PathVariable long id){
        return ResponseEntity.ok(service.updateMovie(request, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable long id){
        service.deleteMovieById(id);
        return ResponseEntity.ok().build();
    }
}
