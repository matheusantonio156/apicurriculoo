package com.example.api_curriculo.controller;

import com.example.api_curriculo.entity.Experiencia;
import com.example.api_curriculo.repository.ExperienciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/experiencia")
public class ExperienciaController {

    @Autowired
    private ExperienciaRepository experienciaRepository;

    @GetMapping
    public ResponseEntity<?> listar() {
        List<Experiencia> experiencias = experienciaRepository.findAll();
        if (experiencias.isEmpty()) {
            return ResponseEntity.ok("Não há experiência profissional cadastrada.");
        }
        return ResponseEntity.ok(experiencias);
    }

    @PostMapping
    public Experiencia adicionar(@RequestBody Experiencia experiencia) {
        return experienciaRepository.save(experiencia);
    }

    // Adicione outros métodos conforme necessário (PUT, DELETE, etc.)
}
