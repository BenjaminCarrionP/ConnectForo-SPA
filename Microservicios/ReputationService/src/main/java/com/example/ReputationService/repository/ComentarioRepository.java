package com.example.ReputationService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ReputationService.model.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
    long count();
    long countByIdUsuario(Long idUsuario);
}
