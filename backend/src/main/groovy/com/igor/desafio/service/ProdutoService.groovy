package com.igor.desafio.service

import com.igor.desafio.model.Produto
import com.igor.desafio.repository.ProdutoRepository
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProdutoService {
    @Autowired
    ProdutoRepository produtoRepository

    @Transactional
    Produto salvar(Produto produto) {
        return produtoRepository.save(produto)
    }

    @Transactional
    Optional<Produto> buscarPorId(Long id) {
        return produtoRepository.findById(id)
    }

    @Transactional
    List<Produto> buscarTodas() {
        return produtoRepository.findAll()
    }

    @Transactional
    void deletar(Produto produto) {
        produtoRepository.delete(produto)
    }
}
