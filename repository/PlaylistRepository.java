package com.example.audible.repository;

import com.example.audible.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<Playlist,Integer> {
}

