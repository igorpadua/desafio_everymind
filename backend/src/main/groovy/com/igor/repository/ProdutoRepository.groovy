package com.igor.repository

import com.igor.model.Produto
import org.springframework.data.jpa.repository.JpaRepository

interface ProdutoRepository extends JpaRepository<Produto, Long> {
}