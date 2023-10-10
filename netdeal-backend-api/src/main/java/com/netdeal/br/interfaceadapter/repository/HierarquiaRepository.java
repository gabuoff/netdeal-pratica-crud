package com.netdeal.br.interfaceadapter.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.netdeal.br.domain.model.Hierarquia;

public interface HierarquiaRepository extends MongoRepository<Hierarquia, String> {
    boolean existsByCargo(String cargo);
}
