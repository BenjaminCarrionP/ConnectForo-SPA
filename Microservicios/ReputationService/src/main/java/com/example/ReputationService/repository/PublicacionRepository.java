package com.example.ReputationService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ReputationService.model.Publicacion;

public interface PublicacionRepository extends JpaRepository<Publicacion, Long> {
    long countByIdUsuario(Long idUsuario);
    long count();
}
