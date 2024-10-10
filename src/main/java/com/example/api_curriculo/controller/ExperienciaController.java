package com.example.api_curriculo.controller;

import com.example.api_curriculo.entity.Experiencia;
import com.example.api_curriculo.repository.ExperienciaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/experiencia")
public class ExperienciaController {

    private final ExperienciaRepository experienciaRepository;

    public ExperienciaController(ExperienciaRepository experienciaRepository) {
        this.experienciaRepository = experienciaRepository;
    }

    @GetMapping
    public List<Experiencia> listar() {
        return experienciaRepository.findAll();
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
