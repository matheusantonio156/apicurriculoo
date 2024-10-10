package com.example.api_curriculo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "experiencia") // Nome da tabela no banco de dados
public class Experiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Geração automática do ID
    private Long id;

    private String descricao;  // Descrição da experiência
    private String nome;       // Nome do cargo ou posição
    private String idade;      // Idade da pessoa
    private String endereco;   // Endereço da pessoa
    private String curso;      // Curso ou formação da pessoa (se necessário)

    // Getters e Setters são gerados automaticamente pelo Lombok
}
