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

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return informacoesPessoaisRepository.findById(id)
            .map(informacoes -> ResponseEntity.ok(informacoes))
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<InformacoesPessoais> adicionar(@RequestBody InformacoesPessoais informacoesPessoais) {
        InformacoesPessoais novaInformacao = informacoesPessoaisRepository.save(informacoesPessoais);
        return ResponseEntity.ok(novaInformacao);
    }

    // Adicione outros métodos conforme necessário (PUT, DELETE, etc.)
}
