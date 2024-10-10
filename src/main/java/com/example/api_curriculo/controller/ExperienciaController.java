package com.example.api_curriculo.controller;

import com.example.api_curriculo.entity.Experiencia;
import com.example.api_curriculo.repository.ExperienciaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/experiencia")
public class ExperienciaController {

    private final ExperienciaRepository experienciaRepository;

    public ExperienciaController(ExperienciaRepository experienciaRepository) {
        this.experienciaRepository = experienciaRepository;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> listar() {
        List<Experiencia> experiencias = experienciaRepository.findAll();
        Map<String, Object> response = new HashMap<>();
        
        if (experiencias.isEmpty()) {
            response.put("mensagem", "Ainda não tenho experiência profissional.");
        } else {
            response.put("experiencias", experiencias);
        }
        
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public Experiencia criar(@RequestBody Experiencia experiencia) {
        return experienciaRepository.save(experiencia);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Experiencia> buscarPorId(@PathVariable Long id) {
        return experienciaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Experiencia> atualizar(@PathVariable Long id, @RequestBody Experiencia experiencia) {
        return experienciaRepository.findById(id)
                .map(existente -> {
                    existente.setCargo(experiencia.getCargo());
                    existente.setEmpresa(experiencia.getEmpresa());
                    existente.setDataInicio(experiencia.getDataInicio());
                    existente.setDataFim(experiencia.getDataFim());
                    existente.setDescricao(experiencia.getDescricao());
                    experienciaRepository.save(existente);
                    return ResponseEntity.ok(existente);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (experienciaRepository.existsById(id)) {
            experienciaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

