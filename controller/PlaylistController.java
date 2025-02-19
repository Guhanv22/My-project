package com.example.audible.controller;

import com.example.audible.Service.PlaylistService;
import com.example.audible.model.Playlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/playlist")
public class PlaylistController {
    @Autowired
    private PlaylistService playlistService;
    @GetMapping
    public List<Playlist> getAllPlaylists() {
        return playlistService.getAllPlaylist();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Playlist> getPlaylistById(@PathVariable int id) {
        return playlistService.getPlaylistById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping("/addPlaylistDetails")
    public Playlist postPlaylistDetails(@RequestBody Playlist playlist){
        return playlistService.savePlaylistDetails(playlist);
    }
}