package com.example.CategoryService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.CategoryService.model.Categoria;
import com.example.CategoryService.service.CategoriaService;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @PostMapping
    public Categoria crear(@RequestBody Categoria categoria) {
        return service.crearCategoria(categoria);
    }

    @GetMapping
    public List<Categoria> listar() {
        return service.obtenerTodas();
    }

    @GetMapping("/{id}")
    public Categoria obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Categoria actualizar(@PathVariable Long id, @RequestBody Categoria nuevaCategoria) {
        return service.actualizarCategoria(id, nuevaCategoria);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminarCategoria(id);
    }

    @GetMapping("/foro/{idForo}")
    public List<Categoria> listarPorForo(@PathVariable Long idForo) {
        return service.obtenerPorIdForo(idForo);
    }
}