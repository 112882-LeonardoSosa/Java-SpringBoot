import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { Empleado } from 'src/app/models/empleado';
import { EmpleadoService } from 'src/app/services/empleado.service';

@Component({
  selector: 'app-lista-empleados',
  templateUrl: './lista-empleados.component.html',
  styleUrls: ['./lista-empleados.component.css']
})
export class ListaEmpleadosComponent implements OnInit {

  listaEmpleados: Empleado[];
  cargando = true;
  private subscription = new Subscription();

  constructor(private router: Router, private serviceEmpleado: EmpleadoService) { 

  }

  ngOnInit(): void {
    this.subscription.add(
      this.serviceEmpleado.obtenerListado().subscribe({
        next: (listado: Empleado[]) => {
          this.listaEmpleados = listado;
        },
        error: () => {
          alert('error al obtener Empleados');
        },
      })
    );
  }

}
