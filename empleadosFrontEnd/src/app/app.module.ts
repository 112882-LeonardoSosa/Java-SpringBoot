import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AltaEmpleadoComponent } from './components/alta-empleado/alta-empleado.component';
import { NavbarComponent } from './components/shared/navbar/navbar.component';
import { ListaEmpleadosComponent } from './components/lista-empleados/lista-empleados.component';
//IMPORTS IMPORTANTES
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
@NgModule({
  declarations: [
    AppComponent,
    AltaEmpleadoComponent,
    NavbarComponent,
    ListaEmpleadosComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
