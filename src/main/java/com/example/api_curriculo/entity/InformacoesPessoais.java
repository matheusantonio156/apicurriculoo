package com.example.api_curriculo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "informacoes_pessoais")
public class InformacoesPessoais {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String endereco;
    private String resumo;
    private String idade;
    private String curso;

    // Adicione outros campos conforme necessário
}
