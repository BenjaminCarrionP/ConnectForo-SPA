package com.example.AuthService.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class JwtUtil {
    private final String secreto = "TuSecretoMuySeguro";
    private final long expiracion = 3600000;

    public String generarToken(Long id, String correo) {
        return Jwts.builder()
                .setSubject(correo)
                .claim("id", id)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiracion))
                .signWith(SignatureAlgorithm.HS512, secreto)
                .compact();
    }

    public Claims obtenerDatos(String token) {
        return Jwts.parser()
                .setSigningKey(secreto)
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean validarToken(String token) {
        try {
            return obtenerDatos(token).getExpiration().after(new Date());
        } catch (Exception e) {
            return false;
        }
    }
}
