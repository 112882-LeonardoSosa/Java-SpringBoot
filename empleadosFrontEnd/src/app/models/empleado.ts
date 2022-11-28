import { Area } from "./area";

export class Empleado {
    id?: number;
    legajo: number;
    nombre: string;
    fechaNacimiento: Date;
    antiguedad: number;
    area: Area;
    sueldoBruto: number;
    fechaIngreso: Date;
}