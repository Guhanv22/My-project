package com.example.audible.Service;
import com.example.audible.model.Audiocast;
import com.example.audible.model.Language;
import com.example.audible.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class LanguageService {
    @Autowired
    private LanguageRepository languageRepository;
    public List<Language> getAllLanguage(){
        return languageRepository.findAll();
    }

    public Optional<Language> getLanguageById(int id) {
        return languageRepository.findById(id);
    }

    public Language createLanguage(Language language) {
        return languageRepository.save(language);
    }

    public Language saveLanguageDetails(Language language){

        return languageRepository.save(language);
    }
}
