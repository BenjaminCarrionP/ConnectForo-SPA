package com.example.CommentService.controller;

import com.example.CommentService.model.Comentario;
import com.example.CommentService.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comentarios")
public class ComentarioController {

    @Autowired
    private ComentarioRepository comentarioRepository;

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