package com.example.audible.repository;

import com.example.audible.model.Favourites;
import org.springframework.data.jpa.repository.JpaRepository;
public interface FavouritesRepository extends JpaRepository<Favourites,Integer>{
}
