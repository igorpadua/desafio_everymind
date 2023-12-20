import {Component, OnInit} from '@angular/core';
import {Produto} from "../../model/produto.model";
import {ProdutoService} from "../../service/produto.service";
import {ActivatedRoute, Router} from "@angular/router";
import {FormsModule} from "@angular/forms";

@Component({
  selector: 'app-produto-update',
  standalone: true,
  imports: [
    FormsModule
  ],
  templateUrl: './produto-update.component.html',
  styleUrl: './produto-update.component.css'
})
export class ProdutoUpdateComponent implements OnInit {

  produto: Produto = {
    id: 0,
    nome: '',
    codigo: 0,
    descricao: '',
    preco: 0.0,
  }

  constructor(private produtoService: ProdutoService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    const id: number = Number(this.route.snapshot.paramMap.get('id'));
    if (id) {
      this.produtoService.readById(id).subscribe(produto => {
        this.produto = produto;
      })
    }
  }

  updateProduto() {
    this.produtoService.update(this.produto).subscribe(() => {
      alert('Produto atualizado com sucesso!')
    })
    this.router.navigate(['/']);
  }

  cancel() {
    this.router.navigate(['/']);
  }
}
