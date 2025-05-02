package com.example.ForumService.repository;

import com.example.ForumService.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemaRepository extends JpaRepository<Tema, Long> {
    // List<Tema> findByTituloContainingIgnoreCase(String titulo);
}