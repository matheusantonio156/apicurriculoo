package com.example.api_curriculo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.api_curriculo.entity.InformacoesPessoais;

public interface InformacoesPessoaisRepository extends JpaRepository<InformacoesPessoais, Long> {
}
