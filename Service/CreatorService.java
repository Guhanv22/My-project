package com.example.audible.Service;


import com.example.audible.model.Audio;
import com.example.audible.model.Creator;
import com.example.audible.repository.CreatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreatorService {
    @Autowired
    private CreatorRepository creatorRepository;
    public List<Creator> getAllCreators() {
        return creatorRepository.findAll();
    }

    public Optional<Creator> getCreatorById(int id) {
        return creatorRepository.findById(id);
    }

    public Creator createCreator(Creator creator) {
        return creatorRepository.save(creator);
    }



    public Creator saveCreatorDetails(Creator creator){
        return creatorRepository.save(creator);

    }
}
