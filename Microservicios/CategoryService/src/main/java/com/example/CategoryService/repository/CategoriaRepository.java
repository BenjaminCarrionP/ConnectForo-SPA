package com.example.CategoryService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CategoryService.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    List<Categoria> findByIdForo(Long idForo);
    List<Categoria> findByIdCategoria(Long idCategoria);
}
