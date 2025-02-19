package com.example.audible.Service;
import com.example.audible.model.Genre;
import com.example.audible.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class GenreService {
    @Autowired
    private GenreRepository genreRepository;


        public List<Genre> getAllGenre() {
            return genreRepository.findAll();
        }

        public  Optional<Genre> getGenreById(int id) {
            return genreRepository.findById(id);
        }

        public Genre createGenre(Genre genre) {
            return genreRepository.save(genre);
        }

        public Genre saveGenreDetails(Genre genre){

            return genreRepository.save(genre);
    }
}
