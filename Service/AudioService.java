
package com.example.audible.Service;

import com.example.audible.model.Audio;
import com.example.audible.repository.AudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;


@Service
public class AudioService {

    @Autowired
    private AudioRepository audioRepository;

    public List<Audio> getAllAudios() {
        return audioRepository.findAll();
    }

    public List<Audio> searchAudios(String query) {
        List<Audio> audios = audioRepository.findByTitleContainingIgnoreCase(query);
        for (Audio audio : audios) {
            audio.setImageUrl(audio.getFullImageUrl());
        }
        return audios;
    }

    public Optional<Audio> getAudioByTitle(String title) {
        return audioRepository.findByTitle(title);
    }

    public Optional<Audio> getAudioById(int id) {
        return audioRepository.findById(id);
    }

    public Audio createAudio(Audio audio) {
        return audioRepository.save(audio);
    }

    public Audio saveAudioDetails(Audio audio) {
        return audioRepository.save(audio);
    }
}
