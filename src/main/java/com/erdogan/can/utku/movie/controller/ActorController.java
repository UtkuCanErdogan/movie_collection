package com.erdogan.can.utku.movie.controller;

import com.erdogan.can.utku.movie.dto.ActorDto;
import com.erdogan.can.utku.movie.dto.CreateActorRequest;
import com.erdogan.can.utku.movie.dto.UpdateActorRequest;
import com.erdogan.can.utku.movie.model.Actor;
import com.erdogan.can.utku.movie.service.ActorServiceImpl;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
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

    @GetMapping("{id}")
    public ResponseEntity<ActorDto> getActorById(@PathVariable long id){
        return ResponseEntity.ok(service.getActorById(id));
    }

    @GetMapping("/actors")
    public ResponseEntity<List<ActorDto>> getAllActors(){
        return ResponseEntity.ok(service.getAllActors());
    }

    @PostMapping("/create")
    public ResponseEntity<ActorDto> createActor(@RequestBody CreateActorRequest request){
        return ResponseEntity.ok(service.createActor(request));
    }

    @PutMapping("{id}/update")
    public ResponseEntity<ActorDto> updateActor(@RequestBody UpdateActorRequest request, @PathVariable long id){
        return ResponseEntity.ok(service.updateActor(request, id));
    }

    @DeleteMapping("{id}/delete")
    public ResponseEntity<Void> deleteActor(@PathVariable("id") long id){
        service.deleteActor(id);
        return ResponseEntity.ok().build();
    }
}
