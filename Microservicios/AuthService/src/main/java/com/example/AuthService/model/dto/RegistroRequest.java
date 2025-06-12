package com.example.AuthService.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistroRequest {
    private String correo;
    private String clave;
    private String username;
    private String rol = "USER";
    private String nombre;
    private String biografia;
    private String fotoPerfil;
}
