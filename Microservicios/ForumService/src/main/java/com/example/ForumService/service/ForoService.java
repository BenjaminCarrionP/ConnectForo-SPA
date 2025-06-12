package com.example.ForumService.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ForumService.controller.ForoController.CategoriaClient;
import com.example.ForumService.model.ExceptionsAll;
import com.example.ForumService.model.Foro;
import com.example.ForumService.model.ForoDTO;
import com.example.ForumService.repository.ForoRepository;

@Service
public class ForoService {
    private final ForoRepository foroRepository;
    private final CategoriaClient categoriaClient;

    @Autowired
    public ForoService(ForoRepository foroRepository, CategoriaClient categoriaClient) {
        this.foroRepository = foroRepository;
        this.categoriaClient = categoriaClient;
    }

    public ForoDTO obtenerForoConCategoria(Long foroId) {
        // Recuperar el foro
        Foro foro = foroRepository.findById(foroId).orElseThrow(() -> new RuntimeException("Foro no encontrado"));

        // Hacer la llamada al microservicio de Categoria para obtener detalles de la categoría
        CategoriaClient categoria = categoriaClient.obtenerCategoria(foro.getCategoriaId());

        // Puedes agregar la categoría a un DTO o devolver el foro con la información de la categoría
        ForoDTO foroDTO = new ForoDTO();
        foroDTO.setId(foro.getId());
        foroDTO.setTitulo(foro.getTitulo());
        foroDTO.setDescripcion(foro.getDescripcion());
        foroDTO.setCategoriaId(categoria.getId());
        foroDTO.setCategoriaNombre(categoria.getNombre());  // Si lo necesitas

        return foroDTO;
    }
    public List<ForoDTO> obtenerForosPorCategoria(Long categoriaId) {
        List<Foro> foros = foroRepository.findByCategoriaId(categoriaId);
        List<ForoDTO> foroDTOs = new ArrayList<>();

        for (Foro foro : foros) {
            CategoriaClient categoria = categoriaClient.obtenerCategoria(foro.getCategoriaId());
            if (categoria == null) {
                throw new ExceptionsAll("Categoría no encontrada para el ID: " + foro.getCategoriaId());
            }
            ForoDTO foroDTO = new ForoDTO();
            foroDTO.setId(foro.getId());
            foroDTO.setTitulo(foro.getTitulo());
            foroDTO.setDescripcion(foro.getDescripcion());
            foroDTO.setCategoriaId(categoria.getId());
            foroDTO.setCategoriaNombre(categoria.getNombre());

            foroDTOs.add(foroDTO);
        }

        return foroDTOs;
    }
}