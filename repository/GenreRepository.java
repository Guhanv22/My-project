package com.example.audible.repository;

import com.example.audible.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre,Integer> {
}
