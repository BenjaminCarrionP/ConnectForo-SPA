package com.example.AuthService.controller;

import com.example.AuthService.model.entity.Usuarios;
import com.example.AuthService.model.dto.RegistroRequest;
import com.example.AuthService.model.dto.LoginRequest;
import com.example.AuthService.service.ServicioAutenticacion;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AutenticacionControlador {

    private final ServicioAutenticacion servicio;

    public AutenticacionControlador(ServicioAutenticacion servicio) {
        this.servicio = servicio;
    }

    @PostMapping("/registro")
    public Usuarios registro(@RequestBody RegistroRequest req) {
        return servicio.registrar(req);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest req) {
        return servicio.login(req);
    }
}
