package com.example.AuthService.service;

import com.example.AuthService.model.entity.Usuarios;
import com.example.AuthService.model.dto.RegistroRequest;
import com.example.AuthService.model.dto.LoginRequest;
import com.example.AuthService.repository.UsuariosRepository;
import com.example.AuthService.security.JwtUtil;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

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

        Usuarios usuario = Usuarios.builder()
                .correo(req.getCorreo())
                .clave(encoder.encode(req.getClave()))
                .username(req.getUsername())
                .rol(req.getRol())
                .nombre(req.getNombre())
                .biografia(req.getBiografia())
                .fotoPerfil(req.getFotoPerfil())
                .activo(true)
                .fechaRegistro(LocalDateTime.now())
                .build();

        return repo.save(usuario);
    }

    public String login(LoginRequest req) {
        Usuarios u = repo.findByCorreo(req.getCorreo())
            .orElseThrow(() -> new IllegalArgumentException("Correo no registrado"));

        if (!encoder.matches(req.getClave(), u.getClave())) {
            throw new IllegalArgumentException("Clave incorrecta");
        }

        return jwtUtil.generarToken(u.getId(), u.getCorreo(),u.getUsername(), u.getRol());
    }
}