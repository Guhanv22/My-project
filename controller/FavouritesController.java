package com.example.audible.controller;

import com.example.audible.Service.FavouritesService;
import com.example.audible.model.Favourites;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/favourites")
public class FavouritesController {

    @Autowired
    private FavouritesService favouritesService;

    @GetMapping
    public List<Favourites> getAllFavourites() {
        return favouritesService.getAllFavourites();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Favourites> getFavouritesById(@PathVariable int id) {
        return favouritesService.getFavouriteById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/addFavouritesDetails")
    public Favourites postFavouritesDetails(@RequestBody Favourites favourites){
        return favouritesService.saveFavouritesDetails(favourites);
    }
}
