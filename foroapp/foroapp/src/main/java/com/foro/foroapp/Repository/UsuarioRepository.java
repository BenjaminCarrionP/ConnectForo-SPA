package com.foro.foroapp.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foro.foroapp.Model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{
    Optional<Usuario> findByCorreo(String correo);
    //Consulta de sql pero de spring boot
    //basicamente en repository hace consultas
}
