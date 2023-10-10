package com.netdeal.br.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
@Document(collection = "colaborador")
public class Colaborador {

    @Id
    private String id;
    
    @JsonProperty("nome")
    private String nome;

    @JsonProperty("cargo")
    private String cargo;

    @JsonProperty("senha")
    private String senha;

    @JsonProperty("hierarquia")
    private String hierarquia;

    @JsonProperty("forcaDaSenha")
    private int forcaDaSenha;

}