package com.example.api_curriculo.repository;

import com.example.api_curriculo.entity.InformacoesPessoais;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformacoesPessoaisRepository extends CrudRepository<InformacoesPessoais, Long> {
    // Métodos adicionais podem ser adicionados se necessário
}
