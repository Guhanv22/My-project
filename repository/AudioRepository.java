

package com.example.audible.repository;

import com.example.audible.model.Audio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AudioRepository extends JpaRepository<Audio, Integer> {


    List<Audio> findByTitleContainingIgnoreCase(String title);


    Optional<Audio> findByTitle(String title);

}
