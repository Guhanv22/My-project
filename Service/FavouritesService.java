package com.example.audible.Service;

import com.example.audible.model.Creator;
import com.example.audible.model.Favourites;
import com.example.audible.repository.FavouritesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FavouritesService {
    @Autowired
    private FavouritesRepository favouritesRepository;
    public List<Favourites> getAllFavourites() {
        return favouritesRepository.findAll();
    }

    public Optional<Favourites> getFavouriteById(int id) {
        return favouritesRepository.findById(id);
    }

    public Favourites saveFavouritesDetails(Favourites favourites)
    {
        return favouritesRepository.save(favourites);

    }
}
