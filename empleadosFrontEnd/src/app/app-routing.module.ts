import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AltaEmpleadoComponent } from './components/alta-empleado/alta-empleado.component';
import { ListaEmpleadosComponent } from './components/lista-empleados/lista-empleados.component';

const routes: Routes = [
  {path:'lista', component: ListaEmpleadosComponent},
  {path:'empleado', component: AltaEmpleadoComponent},
  {path:'**', pathMatch: 'full', redirectTo: 'lista'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
