package com.example.audible.Service;

import com.example.audible.model.Audiocast;
import com.example.audible.model.Playlist;
import com.example.audible.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistService {
    @Autowired
    private PlaylistRepository playlistRepository;
    public List<Playlist> getAllPlaylist() {
        return playlistRepository.findAll();
    }

    public Optional<Playlist> getPlaylistById(int id) {
        return playlistRepository.findById(id);
    }

    public Playlist createPlaylist(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    public Playlist savePlaylistDetails(Playlist playlist){

        return playlistRepository.save(playlist);
    }


}
