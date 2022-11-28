import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { Area } from 'src/app/models/area';
import { Empleado } from 'src/app/models/empleado';
import { AreaService } from 'src/app/services/area.service';
import { EmpleadoService } from 'src/app/services/empleado.service';

@Component({
  selector: 'app-alta-empleado',
  templateUrl: './alta-empleado.component.html',
  styleUrls: ['./alta-empleado.component.css']
})
export class AltaEmpleadoComponent implements OnInit {

  public formularioAlta: FormGroup;
  public empleado: Empleado;
  public listaEmpleados: Empleado[] = [];
  public cargando = true;
  areas: Area[];
  // Seleccionamos o iniciamos el valor '0' del <select>
  areaSeleccionada: Area;
  verSeleccion: string = '';
  private subscription = new Subscription();


  public socioPorDefecto: Empleado;


  constructor(public fb: FormBuilder, private serviceArea: AreaService,
              private router: Router, private serviceEmpleado: EmpleadoService) {
    this.formularioAlta = this.fb.group({
      nombre: ["", [Validators.pattern('[a-zA-Z ]*'), Validators.required]],
      legajo: ["", [Validators.minLength(5), Validators.maxLength(5), Validators.required]],
      area: ["", [Validators.required, Validators.min(1)]],
      fechaIngreso: ["", [Validators.required]],
      antiguedad: [""],
      fechaNacimiento: ["", [Validators.required]],
      sueldoBruto: ["",[Validators.required]]
    }

    );

    this.listaEmpleados.push(this.socioPorDefecto);

  }

  ngOnInit(): void {
    this.subscription.add(
      this.serviceArea.obtenerListado().subscribe({
        next: (listado: Area[]) => {
          this.areas = listado;
        },
        error: () => {
          alert('error al obtener Áreas');
        },
      })
    );
  }

  public get nombre() { return this.formularioAlta.get('nombre') };
  public get legajo() { return this.formularioAlta.get('legajo') };
  public get area() { return this.formularioAlta.get('area') };
  public get antiguedad() { return this.formularioAlta.get('antiguedad') };
  public get sueldoBruto() { return this.formularioAlta.get('sueldoBruto') };
  public get fechaNacimiento() { return this.formularioAlta.get('fechaNacimiento') };
  public get fechaIngreso() { return this.formularioAlta.get('fechaIngreso') };


  public agregar() {
    
    console.log(this.formularioAlta.value);

    if (this.formularioAlta.invalid) {
      alert("faltan campos por completar")
      return;
    }
    else {
      alert(`Socio ${this.nombre?.value} guardado con éxito`);
      this.empleado = new Empleado();
      this.empleado.nombre = this.nombre?.value;
      this.empleado.legajo = this.legajo?.value;
      this.empleado.area = this.area?.value;
      this.empleado.antiguedad = this.antiguedad?.value;
      this.empleado.sueldoBruto = this.sueldoBruto?.value;
      this.empleado.fechaNacimiento = this.fechaNacimiento?.value;
      this.empleado.fechaIngreso = this.fechaIngreso?.value;
      this.subscription.add(
        this.serviceEmpleado.agregar(this.empleado).subscribe({
          next: () => {
            
          },
          error: (e) => {
           console.log(e)
          },
        })
      );
      console.log(this.empleado);
      this.listaEmpleados.push(this.empleado);

    }

  }

}
