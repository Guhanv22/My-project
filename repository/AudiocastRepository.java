package com.example.audible.repository;

import com.example.audible.model.Audiocast;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AudiocastRepository extends JpaRepository<Audiocast,Integer> {
}