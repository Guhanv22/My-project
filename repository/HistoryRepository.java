package com.example.audible.repository;

import com.example.audible.model.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History,Integer> {
}