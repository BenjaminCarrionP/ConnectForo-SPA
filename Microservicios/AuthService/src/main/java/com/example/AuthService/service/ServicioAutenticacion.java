package com.example.AuthService.service;

import com.example.AuthService.model.entity.Usuarios;
import com.example.AuthService.model.dto.RegistroRequest;
import com.example.AuthService.model.dto.LoginRequest;
import com.example.AuthService.repository.UsuariosRepository;
import com.example.AuthService.security.JwtUtil;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class ServicioAutenticacion {

    private final UsuariosRepository repo;
    private final PasswordEncoder encoder;
    private final JwtUtil jwtUtil;

    public ServicioAutenticacion(UsuariosRepository repo,
                                 PasswordEncoder encoder,
                                 JwtUtil jwtUtil) {
        this.repo = repo;
        this.encoder = encoder;
        this.jwtUtil = jwtUtil;
    }

    public Usuarios registrar(RegistroRequest req) {
        if (repo.findByCorreo(req.getCorreo()).isPresent()) {
            throw new IllegalArgumentException("Correo ya existe");
        }
        String claveEnc = encoder.encode(req.getClave());
        Usuarios u = new Usuarios(req.getCorreo(), claveEnc);
        return repo.save(u);
    }

    public String login(LoginRequest req) {
        Usuarios u = repo.findByCorreo(req.getCorreo())
            .orElseThrow(() -> new IllegalArgumentException("Correo no registrado"));
        if (!encoder.matches(req.getClave(), u.getClave())) {
            throw new IllegalArgumentException("Clave incorrecta");
        }
        return jwtUtil.generarToken(u.getId(), u.getCorreo());
    }
}
