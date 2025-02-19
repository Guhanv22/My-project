package com.example.audible.controller;
import com.example.audible.Service.LanguageService;
import com.example.audible.model.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/language")

public class LanguageController {
    @Autowired
    private LanguageService languageService;
    @GetMapping
    public List<Language> getAllLanguages() {
        return languageService.getAllLanguage();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Language> getLanguageById(@PathVariable int id) {
        return languageService.getLanguageById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping("/addLanguageDetails")
    public Language postLanguageDetails(@RequestBody Language language){
        return languageService.saveLanguageDetails(language);
    }
}
