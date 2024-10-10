package com.example.api_curriculo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "informacoes_pessoais") // Certifique-se de que a tabela no banco de dados tenha o mesmo nome
public class InformacoesPessoais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String endereco;
    private String resumo;
    private int idade; // Utilize int para idade
    private String curso;
}
