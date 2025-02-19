package com.example.audible.Service;

import com.example.audible.model.History;
import com.example.audible.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service()
public class HistoryService {
    @Autowired
    private HistoryRepository historyRepository;

    public List<History> getAllHistory() {
        return historyRepository.findAll();
    }

    public Optional<History> getHistoryById(int id) {
        return historyRepository.findById(id);
    }

    public History createHistory(History history) {
        return historyRepository.save(history);
    }

    public History saveHistoryDetails(History history){

        return historyRepository.save(history);
    }

}
