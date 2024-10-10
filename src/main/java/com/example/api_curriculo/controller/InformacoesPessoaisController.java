package com.example.api_curriculo.controller;  // Corrigido para 'example'

import com.example.api_curriculo.entity.InformacoesPessoais;  // Certifique-se de que esta importação está correta
import com.example.api_curriculo.repository.InformacoesPessoaisRepository;  // Corrigido para 'example'
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/informacoes")
public class InformacoesPessoaisController {

    @Autowired
    private InformacoesPessoaisRepository informacoesPessoaisRepository;

    @GetMapping
    public List<InformacoesPessoais> findAll() {
        return (List<InformacoesPessoais>) informacoesPessoaisRepository.findAll();  // Converte o resultado para List
    }

    @PostMapping
    public InformacoesPessoais save(@RequestBody InformacoesPessoais informacoes) {
        return informacoesPessoaisRepository.save(informacoes);
    }
}
