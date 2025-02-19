
package com.example.audible.controller;

import com.example.audible.Service.AudioService;
import com.example.audible.model.Audio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class AudioController {

    @Autowired
    private AudioService audioService;


    @PostMapping("/addAudioDetails")
    public Audio postAudioDetails(@RequestBody Audio audio) {
        return audioService.saveAudioDetails(audio);
    }

    @GetMapping("/api/audio/{id}")
    public ResponseEntity<Audio> getAudioById(@PathVariable int id) {
        return audioService.getAudioById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/api/audio")
    public List<Audio> getAllAudio() {
        return audioService.getAllAudios();
    }

    @GetMapping("/api/audio/search")
    public List<Audio> searchAudio(@RequestParam String query) {
        return audioService.searchAudios(query);
    }
}
