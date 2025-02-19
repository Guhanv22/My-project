package com.example.audible.controller;

import com.example.audible.Service.GenreService;
import com.example.audible.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/genre")
public class GenreController {
    @Autowired
    private GenreService genreService;
    @GetMapping
    public List<Genre> getAllGenres() {
        return genreService.getAllGenre();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Genre> getGenreById(@PathVariable int id) {
        return genreService.getGenreById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/addGenreDetails")
    public Genre createGenreDetails(@RequestBody Genre genre){

        return genreService.createGenre(genre);
    }

}

