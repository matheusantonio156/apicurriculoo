package com.example.api_curriculo.controller;

import com.example.api_curriculo.entity.InformacoesPessoais;
import com.example.api_curriculo.repository.InformacoesPessoaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/informacoes")  // Mantém a consistência com o primeiro controller
public class InformacoesPessoaisController {

    @Autowired
    private InformacoesPessoaisRepository informacoesPessoaisRepository;

    @GetMapping
    public List<InformacoesPessoais> findAll() {
        return (List<InformacoesPessoais>) informacoesPessoaisRepository.findAll();
    }

    @PostMapping
    public InformacoesPessoais save(@RequestBody InformacoesPessoais informacoes) {
        return informacoesPessoaisRepository.save(informacoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InformacoesPessoais> buscarPorId(@PathVariable Long id) {
        return informacoesPessoaisRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<InformacoesPessoais> atualizar(@PathVariable Long id, @RequestBody InformacoesPessoais informacoes) {
        return informacoesPessoaisRepository.findById(id)
                .map(existente -> {
                    existente.setNome(informacoes.getNome());
                    existente.setEmail(informacoes.getEmail());
                    // Adicione outros campos que precisar atualizar
                    informacoesPessoaisRepository.save(existente);
                    return ResponseEntity.ok(existente);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (informacoesPessoaisRepository.existsById(id)) {
            informacoesPessoaisRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // Método separado para retornar informações pessoais fixas
    @GetMapping("/detalhes")
    public ResponseEntity<Map<String, String>> obterInformacoesPessoais() {
        Map<String, String> informacoes = new HashMap<>();
        informacoes.put("nome", "Matheus Antonio");
        informacoes.put("idade", "21 anos");
        informacoes.put("endereco", "Recife-PE");
        informacoes.put("telefone", "(81) 9999-9999");
        informacoes.put("curso", "Sistemas para Internet");

        return ResponseEntity.ok(informacoes);
    }
}

