package com.example.api_curriculo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.api_curriculo.entity.InformacoesPessoais;

public interface InformacoesPessoaisRepository extends JpaRepository<InformacoesPessoais, Long> {
    // Você pode adicionar métodos personalizados aqui, se necessário
}
