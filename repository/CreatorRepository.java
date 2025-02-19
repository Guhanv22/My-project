package com.example.audible.repository;

import com.example.audible.model.Creator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreatorRepository extends JpaRepository<Creator,Integer> {
}
