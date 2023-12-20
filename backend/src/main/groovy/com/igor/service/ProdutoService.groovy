package com.igor.service

import com.igor.model.Produto
import com.igor.repository.ProdutoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProdutoService {
    @Autowired
    ProdutoRepository produtoRepository

    @Transactional
    Produto salvar(Produto produto) {
        return produtoRepository.save(produto)
    }

    @Transactional(readOnly = true)
    Optional<Produto> buscarPorId(Integer id) {
        return produtoRepository.findById(id)
    }

    @Transactional(readOnly = true)
    List<Produto> buscarTodas() {
        return produtoRepository.findAll()
    }

    @Transactional
    void deletar(Produto produto) {
        produtoRepository.delete(produto)
    }
}
