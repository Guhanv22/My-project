package com.example.audible.controller;

import com.example.audible.Service.HistoryService;
import com.example.audible.model.Genre;
import com.example.audible.model.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/history")
public class HistoryController {
    @Autowired
    private HistoryService historyService;
    @GetMapping
    public List<History> getAllHistorys() {
        return historyService.getAllHistory();
    }

    @GetMapping("/{id}")
    public ResponseEntity<History> getHistoryById(@PathVariable int id) {
        return historyService.getHistoryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/addHistoryDetails")
    public History postHistoryDetails(@RequestBody History history){
        return historyService.saveHistoryDetails(history);
    }
}

