package com.foro.foroapp.Services;

import java.util.Optional;

import com.foro.foroapp.Model.Usuario;
import com.foro.foroapp.Repository.UsuarioRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class UsuarioService {
    private final UsuarioRepository repo;
    private final PasswordEncoder encoder;
    


//logica de servicio
    public UsuarioService(UsuarioRepository repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    public boolean existeCorreo(String correo) {
        return repo.findByCorreo(correo).isPresent();
    }

    public Usuario registrar(Usuario usuario) {
        usuario.setContrasena(encoder.encode(usuario.getContrasena()));
        return repo.save(usuario);
    }

    public Optional<Usuario> login(String correo, String contrasena) {
        return repo.findByCorreo(correo)
                .filter(u -> encoder.matches(contrasena, u.getContrasena()));
    }
    public Optional<Usuario> buscarPorCorreo(String correo) {
        return repo.findByCorreo(correo);
    }
    public boolean verificarContra(Usuario usuario, String contrasenaIngresada) {
        return encoder.matches(contrasenaIngresada, usuario.getContrasena());
    }
}
