package com.netdeal.br.interfaceadapter.repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.netdeal.br.domain.model.Colaborador;

public interface ColaboradorRepository extends MongoRepository<Colaborador, String> {

     boolean existsByNome(String name);

    }