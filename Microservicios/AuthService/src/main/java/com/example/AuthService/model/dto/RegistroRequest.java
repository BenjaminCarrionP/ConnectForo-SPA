package com.example.AuthService.model.dto;

public class RegistroRequest {

    private String correo;
    private String clave;
    private String nombre;

    public RegistroRequest() {}

    public RegistroRequest(String correo, String clave, String nombre) {
        this.correo = correo;
        this.clave = clave;
        this.nombre = nombre;
    }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getClave() { return clave; }
    public void setClave(String clave) { this.clave = clave; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}
