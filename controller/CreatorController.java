package com.example.audible.controller;

import com.example.audible.Service.CreatorService;
import com.example.audible.model.Audiocast;
import com.example.audible.model.Creator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/creator")
public class CreatorController {
    @Autowired
    private CreatorService creatorService;

    @GetMapping
    public List<Creator> getAllCreators() {
        return creatorService.getAllCreators();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Creator> getCreatorsById(@PathVariable int id) {
        return creatorService.getCreatorById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/addCreatorDetails")
    public Creator postCreatorDetails(@RequestBody Creator creator){
        return creatorService.saveCreatorDetails(creator);
    }

}
