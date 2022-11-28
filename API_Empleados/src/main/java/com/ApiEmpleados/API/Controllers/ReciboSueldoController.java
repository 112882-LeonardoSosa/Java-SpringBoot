package com.ApiEmpleados.API.Controllers;

import com.ApiEmpleados.API.Dtos.DtoRecibo;
import com.ApiEmpleados.API.Models.Empleado;
import com.ApiEmpleados.API.Models.ReciboSueldo;
import com.ApiEmpleados.API.Repository.ReciboSueldoRepository;
import org.hibernate.mapping.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Tuple;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ReciboSueldoController {

    @Autowired
    private ReciboSueldoRepository reciboRepository;

    @PostMapping(value = "/saveRecibo")
    public String saveRecibo(@RequestBody ReciboSueldo recibo){
        if (recibo == null) {
            return "Error al guardar registro de empleado, faltan datos";
        }
        recibo.setSueldoNeto(recibo.getSueldoBruto()+recibo.getMontoAntiguedad()-recibo.getFondoAltaComplejidad()-recibo.getJubilacion()-recibo.getObraSocial());
        reciboRepository.save(recibo);
        return "Registro de empleado cargado con éxito!";
    }

    @GetMapping(value = "/GetRecibos/{legajo}")
    public List<ReciboSueldo> getRecibos(@PathVariable long legajo){
        List<ReciboSueldo> listaConFiltro = new ArrayList<ReciboSueldo>();
        List<ReciboSueldo> todos = reciboRepository.findAll();
        for (ReciboSueldo item: todos) {
            if (item.getLegajo() == legajo){
                listaConFiltro.add(item);
            }
        }
        return listaConFiltro;
    }


    @GetMapping(value = "/getRecibosByFecha/{anio}/{mes}")
    public List<DtoRecibo> getRecibosByFecha(@PathVariable int anio, @PathVariable int mes){
        return reciboRepository.getReporteArea(anio,mes);
    }

}
