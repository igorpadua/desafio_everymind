package com.igor.desafio.model

import groovy.transform.Canonical
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
@Canonical
class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id
    String nome
    Integer codigo
    String descricao
    Double preco
}
