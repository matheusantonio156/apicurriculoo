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

    private String cargo;  // Ex: Desenvolvedor de Software
    private String empresa;
    private String dataInicio;
    private String dataFim;
    private String descricao;  // Descrição do trabalho realizado
}
