package com.example.api_curriculo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "experiencia")
public class Experiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cargo; // Nome do cargo
    private String empresa; // Nome da empresa
    private String dataInicio; // Data de início
    private String dataFim; // Data de fim
    private String descricao; // Descrição da experiência

}

