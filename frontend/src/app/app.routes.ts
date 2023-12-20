import { Routes } from '@angular/router';
import {ProdutoReadComponent} from "./components/produto-read/produto-read.component";
import {ProdutoCreateComponent} from "./components/produto-create/produto-create.component";

export const routes: Routes = [
  {
    path: '',
    component: ProdutoReadComponent
  },
  {
    path: 'novo',
    component: ProdutoCreateComponent
  }
];
