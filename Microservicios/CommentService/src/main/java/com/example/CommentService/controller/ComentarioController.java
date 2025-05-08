package com.example.CommentService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CommentService.model.Comentario;
import com.example.CommentService.repository.ComentarioRepository;

@RestController
@RequestMapping("/api/comentarios")
public class ComentarioController {

    @Autowired
    private ComentarioRepository comentarioRepository;

    @GetMapping
    public List<Comentario> getAllComentarios() {
        return comentarioRepository.findAll();
    }

    @GetMapping("/publicacion/{publicacionId}")
    public List<Comentario> getComentariosByPublicacion(@PathVariable Long publicacionId) {
        return comentarioRepository.findByPublicacionId(publicacionId);
    }

    @PostMapping("/publicacion/{publicacionId}")
    public Comentario crearComentario(@PathVariable Long publicacionId, @RequestBody Comentario comentario) {
        comentario.setPublicacionId(publicacionId);
        return comentarioRepository.save(comentario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComentario(@PathVariable Long id) {
        if (comentarioRepository.existsById(id)) {
            comentarioRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}