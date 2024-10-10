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

    private String nome;       // Nome completo
    private String email;      // Email
    private String endereco;   // Endereço
    private String idade;      // Idade
    private String curso;      // Curso
    private String resumo;     // Resumo pessoal
}
