package com.example.ForumService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ForumService.model.ForoDTO;
import com.example.ForumService.service.ForoService;


@RestController
@RequestMapping("/api/foros")
public class ForoController {
    
    private final ForoService foroService;

    @Autowired
    public ForoController(ForoService foroService) {
        this.foroService = foroService;
    }

    @GetMapping("/")
    public List<ForoDTO> obtenerForos() {
        return foroService.obtenerForosConCategoria();
    }

    @FeignClient(name = "categoria-service", url = "http://localhost:8086") // URL del microservicio de Categoría
    public interface CategoriaClient {

        @GetMapping("/categorias/{id}")
        CategoriaClient obtenerCategoria(@PathVariable("id") Long id);
    }
}
