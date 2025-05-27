package com.example.ReputationService.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "foro")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Publicacion {

    @Id
    private Long id;

    private String titulo;
    private String contenido;
    private Long idUsuario;
    private LocalDateTime fechaPublicacion;
}