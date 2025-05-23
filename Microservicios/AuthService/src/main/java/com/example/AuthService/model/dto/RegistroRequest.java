package com.example.AuthService.model.dto;

public class RegistroRequest {
    private String correo;
    private String clave;

    public RegistroRequest() {}

    public RegistroRequest(String correo, String clave) {
        this.correo = correo;
        this.clave  = clave;
    }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getClave() { return clave; }
    public void setClave(String clave) { this.clave = clave; }
}
