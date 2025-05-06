package com.example.ForumService.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ForumService.model.Tema;
import com.example.ForumService.repository.TemaRepository;

@RestController
@RequestMapping("/api/temas")

public class TemaController {
    
    @Autowired
    private TemaRepository temaRepository;

    @GetMapping
    public List<Tema> getAllTemas() {
        return temaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tema> getTemaById(@PathVariable Long id) {
        Optional<Tema> tema = temaRepository.findById(id);
        return tema.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Tema createTema(@RequestBody Tema tema) {
        return temaRepository.save(tema);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTema(@PathVariable Long id) {
        if (temaRepository.existsById(id)) {
            temaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
