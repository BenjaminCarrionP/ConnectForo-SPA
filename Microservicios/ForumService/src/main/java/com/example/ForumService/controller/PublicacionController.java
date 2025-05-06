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

import com.example.ForumService.model.Publicacion;
import com.example.ForumService.model.Tema;
import com.example.ForumService.repository.PublicacionRepository;
import com.example.ForumService.repository.TemaRepository;

@RestController
@RequestMapping("/api/publicaciones")

public class PublicacionController {

    @Autowired
    private PublicacionRepository publicacionRepository;

    @Autowired
    private TemaRepository temaRepository;

    @GetMapping
    public List<Publicacion> getAllPublicaciones() {
        return publicacionRepository.findAll();
    }
    
    @GetMapping("/tema/{temaId}")
    public ResponseEntity<List<Publicacion>> getPublicacionesPorTema(@PathVariable Long temaId) {
        Optional<Tema> tema = temaRepository.findById(temaId);
        return tema.map(t -> ResponseEntity.ok(t.getPublicaciones())).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/tema/{temaId}")
    public ResponseEntity<Publicacion> createPublicacion(@PathVariable Long temaId, @RequestBody Publicacion publicacion) {
        Optional<Tema> tema = temaRepository.findById(temaId);
        if (tema.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        publicacion.setTema(tema.get());
        Publicacion nueva = publicacionRepository.save(publicacion);
        return ResponseEntity.ok(nueva);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePublicacion(@PathVariable Long id) {
        if (publicacionRepository.existsById(id)) {
            publicacionRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
    

