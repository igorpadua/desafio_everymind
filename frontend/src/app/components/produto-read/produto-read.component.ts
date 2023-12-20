import {Component, OnInit} from '@angular/core';
import {Produto} from "../../model/produto.model";
import {ProdutoService} from "../../service/produto.service";
import {NgForOf} from "@angular/common";
import {RouterLink} from "@angular/router";

@Component({
  selector: 'app-produto-read',
  standalone: true,
  imports: [
    NgForOf,
    RouterLink
  ],
  templateUrl: './produto-read.component.html',
  styleUrl: './produto-read.component.css'
})
export class ProdutoReadComponent implements OnInit {

  produtos: Produto[] = [];

  constructor(private produtoService: ProdutoService) { }

  ngOnInit(): void {
    this.produtoService.read().subscribe(produtos => {
      this.produtos = produtos;
    })
  }

  excluir(produto: Produto) {
    if (confirm(`Tem certeza que deseja excluir o produto ${produto.nome}?`)) {
      this.produtoService.delete(produto.id).subscribe(() => {
        this.produtos = this.produtos.filter(p => p != produto);
      })
    }
  }
}
