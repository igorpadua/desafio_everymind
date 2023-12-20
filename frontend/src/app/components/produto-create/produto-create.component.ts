import { Component } from '@angular/core';
import {Produto} from "../../model/produto.model";
import {Router} from "@angular/router";
import {ProdutoService} from "../../service/produto.service";
import {FormsModule} from "@angular/forms";

@Component({
  selector: 'app-produto-create',
  standalone: true,
  imports: [
    FormsModule
  ],
  templateUrl: './produto-create.component.html',
  styleUrl: './produto-create.component.css'
})
export class ProdutoCreateComponent {

  produto: Produto = {
    id: 0,
    nome: '',
    codigo: 0,
    descricao: '',
    preco: 0.0,
  }

  constructor(private router: Router, private produtoService: ProdutoService) { }

  criarProduto() {
    this.produtoService.create(this.produto).subscribe(() => {
      alert('Produto criado com sucesso!')
    })
    this.router.navigate(['/']);
  }

  cancelar() {
    this.router.navigate(['/']);
  }
}
