package com.example.api_curriculo.controller;

import com.example.api_curriculo.entity.InformacoesPessoais;
import com.example.api_curriculo.repository.InformacoesPessoaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/informacoes")
public class InformacoesPessoaisController {

    @Autowired
    private InformacoesPessoaisRepository informacoesPessoaisRepository;

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<InformacoesPessoais> informacoes = (List<InformacoesPessoais>) informacoesPessoaisRepository.findAll();
        if (informacoes.isEmpty()) {
            return ResponseEntity.ok("Nenhuma informação pessoal encontrada.");
        }
        return ResponseEntity.ok(informacoes);
    }

    @PostMapping
    public InformacoesPessoais adicionar(@RequestBody InformacoesPessoais informacoesPessoais) {
        return informacoesPessoaisRepository.save(informacoesPessoais);
    }

    // Adicione outros métodos conforme necessário (PUT, DELETE, etc.)
}
