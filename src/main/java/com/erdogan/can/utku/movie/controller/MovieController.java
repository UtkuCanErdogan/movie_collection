package com.erdogan.can.utku.movie.controller;

import com.erdogan.can.utku.movie.dto.CreateMovieRequest;
import com.erdogan.can.utku.movie.dto.MovieDto;
import com.erdogan.can.utku.movie.dto.UpdateMovieRequest;
import com.erdogan.can.utku.movie.model.MovieType;
import com.erdogan.can.utku.movie.service.MovieServiceImpl;
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

    @GetMapping("/{name}")
    public ResponseEntity<MovieDto> getMovieByName(@PathVariable String name){
        return ResponseEntity.ok(service.getMovieByName(name));
    }

    @GetMapping("/moviesbyyear")
    public ResponseEntity<List<MovieDto>> getMoviesByYear(){
        return ResponseEntity.ok(service.getMoviesByYear());
    }

    @GetMapping("/{type}")
    public ResponseEntity<List<MovieDto>> getMoviesByType(@PathVariable MovieType type){
        return ResponseEntity.ok(service.getMoviesByType(type));
    }

    @PostMapping("/create")
    public ResponseEntity<MovieDto> createMovie(@RequestBody CreateMovieRequest request){
        return ResponseEntity.ok(service.createMovie(request));
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<MovieDto> updateMovie(@RequestBody UpdateMovieRequest request, @PathVariable long id){
        return ResponseEntity.ok(service.updateMovie(request, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable("id") long id){
        service.deleteMovie(id);
        return ResponseEntity.ok().build();
    }
}
