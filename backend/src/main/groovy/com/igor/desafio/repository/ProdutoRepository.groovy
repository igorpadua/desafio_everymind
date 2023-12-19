package com.igor.desafio.repository

import com.igor.desafio.model.Produto
import org.springframework.data.jpa.repository.JpaRepository

interface ProdutoRepository extends JpaRepository<Produto, Long> {
}