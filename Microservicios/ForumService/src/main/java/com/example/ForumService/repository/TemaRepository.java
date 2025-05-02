package com.example.ForumService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ForumService.model.Tema;

@Repository
public interface TemaRepository extends JpaRepository<Tema, Long> {
    // List<Tema> findByTituloContainingIgnoreCase(String titulo);
}