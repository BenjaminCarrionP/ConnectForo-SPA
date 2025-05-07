package com.example.NotificationService.controller;

import com.example.NotificationService.model.Notificacion;
import com.example.NotificationService.repository.NotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notificaciones")
public class NotificacionController {

    @Autowired
    private NotificacionService notificacionService;

    @PostMapping
    public ResponseEntity<Notificacion> crearNotificacion(@RequestBody Notificacion notificacion) {
        Notificacion nuevaNotificacion = notificacionService.crearNotificacion(notificacion);
        return ResponseEntity.ok(nuevaNotificacion);
    }

    @GetMapping("/{destinatario}")
    public ResponseEntity<List<Notificacion>> obtenerNotificacionesPorDestinatario(@PathVariable String destinatario) {
        List<Notificacion> notificaciones = notificacionService.obtenerNotificacionesPorDestinatario(destinatario);
        return ResponseEntity.ok(notificaciones);
    }
}