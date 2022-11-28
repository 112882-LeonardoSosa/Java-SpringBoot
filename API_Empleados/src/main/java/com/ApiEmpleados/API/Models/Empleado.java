package com.ApiEmpleados.API.Models;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "empleados", schema = "db_empleados")
public class Empleado {


    //legajo nombre fechaNacimiento antiguedad area sueldoBruto
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "legajo")
    private long legajo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "fechaNacimiento")
    private Date fechaNacimiento;

    @Column(name = "fechaIngreso")
    private Date fechaIngreso;

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    @Column(name = "antiguedad")
    private int antiguedad;

    @ManyToOne
    @JoinColumn(name = "id_area")
    Area area;

    @Column(name = "sueldoBruto")
    private float sueldoBruto;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getLegajo() {
        return legajo;
    }

    public void setLegajo(long legajo) {
        this.legajo = legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public float getSueldoBruto() {
        return sueldoBruto;
    }

    public void setSueldoBruto(float sueldoBruto) {
        this.sueldoBruto = sueldoBruto;
    }
}
