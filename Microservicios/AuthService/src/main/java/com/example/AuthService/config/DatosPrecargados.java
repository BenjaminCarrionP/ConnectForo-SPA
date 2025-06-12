package com.example.AuthService.config;

import com.example.AuthService.model.entity.Usuarios;
import com.example.AuthService.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service

public class DatosPrecargados {
    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    private SeguridadConfig seguridadConfig;  // Usar el servicio para encriptar la clave

    @jakarta.annotation.PostConstruct
    public void init() {
        // Verificar si el usuario administrador ya existe
        if (usuariosRepository.findByUsername("admin") == null && usuariosRepository.findByCorreo("admin@admin.com") == null) {
            // Si no existe, crear el usuario administrador
            String encodedPassword = seguridadConfig.encriptpassword("admin123"); // Cifrar la contraseña

            Usuarios admin = Usuarios.builder()
                    .username("admin")
                    .correo("admin@admin.com")
                    .clave(encodedPassword)  // Asignar la contraseña encriptada
                    .rol("admin")
                    .nombre("Administrador")
                    .biografia("Administrador del sistema")
                    .fotoPerfil("default.jpg")  // Coloca una foto predeterminada si es necesario
                    .build();

            usuariosRepository.save(admin);
            System.out.println("Administrador pre-cargado creado con éxito.");
        }
    }
}

