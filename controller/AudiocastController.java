package com.example.audible.controller;

import com.example.audible.Service.AudiocastService;
import com.example.audible.model.Audiocast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/audiocast")
public class AudiocastController {
    @Autowired
    private AudiocastService audiocastService;

    @GetMapping
    public List<Audiocast> getAllAudiocasts() {
        return audiocastService.getAllAudiocasts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Audiocast> getAudiocastById(@PathVariable int id) {
        return audiocastService.getAudiocastById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Audiocast createAudiocast(@RequestBody Audiocast audiocast) {
        return audiocastService.createAudiocast(audiocast);
    }


}