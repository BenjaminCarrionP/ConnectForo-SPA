package com.example.ReputationService.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comentario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comentario {

    @Id
    private Long id;

    private String contenido;
    private Long idUsuario;
    private Long idPublicacion;
    private LocalDateTime fechaComentario;
}