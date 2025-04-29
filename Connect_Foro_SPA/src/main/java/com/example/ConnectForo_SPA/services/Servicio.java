package com.example.ConnectForo_SPA.services;

import com.example.ConnectForo_SPA.model.Usuario;
import com.example.ConnectForo_SPA.repository.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Servicio {

    @Autowired
    private  UsuarioRepositorio usuarioRepositorio;

    public boolean registrarUsuario(String username, String password, String email) {
        Optional<Usuario> usuarioExistente = usuarioRepositorio.findByUsername(username);

        if (usuarioExistente.isPresent()) {
            return false; 
        }

        Usuario nuevoUsuario = new Usuario(username, password, email);
        usuarioRepositorio.save(nuevoUsuario);
        return true;
    }

    public boolean loginUsuario(String username, String password) {
        Optional<Usuario> usuarioOpt = usuarioRepositorio.findByUsername(username);

        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            return usuario.getPassword().equals(password);
        }

        return false;
    }
}
