package com.example.ReputationService.service;

import com.example.ReputationService.repository.ComentarioRepository;
import com.example.ReputationService.repository.PublicacionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReputationService {

    @Autowired
    private PublicacionRepository publicacionRepository;

    @Autowired
    private ComentarioRepository comentarioRepository;

    public long contarPublicacionesPorUsuario(Long idUsuario) {
        return publicacionRepository.countByIdUsuario(idUsuario);
    }

    public long contarComentariosPorUsuario(Long idUsuario) {
        return comentarioRepository.countByIdUsuario(idUsuario);
    }

    public long calcularReputacion(Long idUsuario) {
        long publicaciones = contarPublicacionesPorUsuario(idUsuario);
        long comentarios = contarComentariosPorUsuario(idUsuario);
        return publicaciones * 10 + comentarios * 3;
    }
}
