package com.ApiEmpleados.API.Dtos;
import javax.annotation.sql.DataSourceDefinition;


public class DtoRecibo  {

    private String area;
    private double sueldoNeto;

    public DtoRecibo(String area, double sueldoNeto) {
        this.area = area;
        this.sueldoNeto = sueldoNeto;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public double getSueldoNeto() {
        return sueldoNeto;
    }

    public void setSueldoNeto(double sueldoNeto) {
        this.sueldoNeto = sueldoNeto;
    }
}
