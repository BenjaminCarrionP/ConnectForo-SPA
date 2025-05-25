package com.example.AuthService.controller;

import com.example.AuthService.model.entity.Usuarios;
import com.example.AuthService.model.dto.RegistroRequest;
import com.example.AuthService.model.dto.LoginRequest;
import com.example.AuthService.service.ServicioAutenticacion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AutenticacionControlador {

    private final ServicioAutenticacion servicio;

    public AutenticacionControlador(ServicioAutenticacion servicio) {
        this.servicio = servicio;
    }

    @PostMapping("/registro")
    public ResponseEntity<?> registro(@RequestBody RegistroRequest req) {
        Usuarios registrado = servicio.registrar(req);
        return ResponseEntity.ok(registrado);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest req) {
        String token = servicio.login(req);
        return ResponseEntity.ok(token);
    }
}