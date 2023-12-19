package com.igor.desafio.controller

import com.igor.desafio.model.Produto
import com.igor.desafio.service.ProdutoService
import groovy.transform.TypeChecked
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/produto")
@TypeChecked
class ProdutoController {

    private final ProdutoService produtoService

    ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Produto salva(@RequestBody @Valid Produto produto) {
        return produtoService.salvar(produto)
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    Produto buscaPorId(@PathVariable Long id) {
        return produtoService.buscarPorId(id)
                .orElseThrow( () ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado")
        )
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<Produto> buscaTodas() {
        return produtoService.buscarTodas()
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleta(@PathVariable Long id) {
        produtoService.buscarPorId(id)
        .map { produto ->
            produtoService.deletar(produto)
            return produto
        }.orElseThrow( () ->
            new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado")
        )
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    Produto atualiza(@PathVariable Long id, @RequestBody @Valid Produto produto) {
        produtoService.buscarPorId(id)
        .map { produtoExistente ->
            produto.id = produtoExistente.id
            produtoService.salvar(produto)
            return produto
        }.orElseThrow( () ->
            new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado")
        )
    }
}
