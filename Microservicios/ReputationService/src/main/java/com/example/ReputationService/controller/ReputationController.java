package com.example.ReputationService.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ReputationService.service.ReputationService;


@RestController
@RequestMapping("/api/reputacion")
public class ReputationController {

    @Autowired
    private ReputationService service;

    @GetMapping("/usuario/{idUsuario}")
    public Map<String, Long> obtenerReputacion(@PathVariable Long idUsuario) {
        long publicaciones = service.contarPublicacionesPorUsuario(idUsuario);
        long comentarios = service.contarComentariosPorUsuario(idUsuario);
        long reputacion = service.calcularReputacion(idUsuario);

        Map<String, Long> resultado = new HashMap<>();
        resultado.put("publicaciones", publicaciones);
        resultado.put("comentarios", comentarios);
        resultado.put("reputacion", reputacion);
        return resultado;
    }
}
