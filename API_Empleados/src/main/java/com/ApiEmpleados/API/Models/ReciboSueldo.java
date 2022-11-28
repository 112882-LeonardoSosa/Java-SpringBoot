package com.ApiEmpleados.API.Models;

import javax.persistence.*;

@Entity
@Table(name = "recibos", schema = "db_empleados")
public class ReciboSueldo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "anio")
    private int anio;

    @Column(name = "mes")
    private int mes;

    //sueldo bruto del empleado
    @Column(name = "sueldoBruto")
    private float sueldoBruto;

    //SE CALCULA EN BASE A a la antiguedad del empleado
    @Column(name = "montoAntiguedad")
    private float montoAntiguedad;

    //DEDUCCIONES jubilacion obraSocial fondoAltaComplejidad
    @Column(name = "jubilacion")
    private float jubilacion;

    @Column(name = "obraSocial")
    private float obraSocial;

    @Column(name = "fondoAltaComplejidad")
    private float fondoAltaComplejidad;

    @Column(name = "legajo")
    private long legajo;
    @ManyToOne
    @JoinColumn(name = "id_empleado")
    Empleado empleado;

    @Column(name = "sueldoNeto")
    private float sueldoNeto;

    public long getLegajo() {
        return legajo;
    }

    public void setLegajo(long legajo) {
        this.legajo = legajo;
    }

    public float getSueldoNeto() {
        return sueldoNeto;
    }

    public void setSueldoNeto(float sueldoNeto) {
        this.sueldoNeto = sueldoNeto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public float getSueldoBruto() {
        return sueldoBruto;
    }

    public void setSueldoBruto(float sueldoBruto) {
        this.sueldoBruto = sueldoBruto;
    }

    public float getMontoAntiguedad() {
        return montoAntiguedad;
    }

    public void setMontoAntiguedad(float montoAntiguedad) {
        this.montoAntiguedad = montoAntiguedad;
    }

    public float getJubilacion() {
        return jubilacion;
    }

    public void setJubilacion(float jubilacion) {
        this.jubilacion = jubilacion;
    }

    public float getObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(float obraSocial) {
        this.obraSocial = obraSocial;
    }

    public float getFondoAltaComplejidad() {
        return fondoAltaComplejidad;
    }

    public void setFondoAltaComplejidad(float fondoAltaComplejidad) {
        this.fondoAltaComplejidad = fondoAltaComplejidad;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}
