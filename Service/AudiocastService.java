package com.example.audible.Service;

import com.example.audible.model.Audio;
import com.example.audible.model.Audiocast;
import com.example.audible.repository.AudiocastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AudiocastService {
    @Autowired
    private AudiocastRepository audiocastRepository;

    public List<Audiocast> getAllAudiocasts() {
        return audiocastRepository.findAll();
    }

    public Optional<Audiocast> getAudiocastById(int id) {
        return audiocastRepository.findById(id);
    }

    public Audiocast createAudiocast(Audiocast audiocast) {
        return audiocastRepository.save(audiocast);
    }

    public Audiocast saveAudiocastDetails(Audiocast audiocast){

        return audiocastRepository.save(audiocast);
    }
}