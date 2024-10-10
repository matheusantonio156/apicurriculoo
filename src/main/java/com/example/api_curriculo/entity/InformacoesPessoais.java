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

    private String endereco;   // Endereço da pessoa
    private String nome;       // Nome da pessoa
    private String telefone;   // Telefone da pessoa
    private String email;      // Email da pessoa
    private String resumo;     // Resumo sobre a pessoa
    private int idade;         // Idade da pessoa
    private String curso;      // Curso que a pessoa está fazendo
}
