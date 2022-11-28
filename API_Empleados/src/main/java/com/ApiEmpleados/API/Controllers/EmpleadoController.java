package com.ApiEmpleados.API.Controllers;

import com.ApiEmpleados.API.Dtos.DtoEmpleado;
import com.ApiEmpleados.API.Dtos.DtoRespuesta;
import com.ApiEmpleados.API.Models.Area;
import com.ApiEmpleados.API.Models.Empleado;
import com.ApiEmpleados.API.Repository.EmpleadoRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmpleadoController {

    //INYECTAMOS EL REPOSITORY DE EMPLEADO
    @Autowired
    private EmpleadoRepository empleadoRepository;


    @GetMapping(value = "/getEmpleados")
    public List<Empleado> getEmpleados(){
        return empleadoRepository.findAll();
    }

    //legajo nombre fechaNacimiento antiguedad area sueldoBruto
    @PostMapping(value = "/saveEmpleado")
    public String saveEmpleado(@RequestBody Empleado empleado){
        int anios = 0;
        if (empleado == null) {
            return "Error al guardar registro de empleado, faltan datos";
        }
        anios = calcularAniosDate(empleado.getFechaIngreso());
        empleado.setAntiguedad(anios);
        empleadoRepository.save(empleado);
        return "Registro de empleado cargado con éxito!";
    }

    @DeleteMapping(value="/deleteEmpleado/{id}")
    public boolean deleteEmpleado(@PathVariable long id){
        if (id != 0) {
            Empleado empEliminado = empleadoRepository.findById(id).get();
            empleadoRepository.delete(empEliminado);
            return true;
        }
        return false;
    }

    @PutMapping(value="/updateEmpleado/{id}")
    public String updateEmpleado(@PathVariable long id, @RequestBody Empleado empleado){
        if (empleado != null && id != 0) {
            Empleado empActualizado = empleadoRepository.findById(id).get();
            empActualizado.setNombre(empleado.getNombre());
            empleadoRepository.save(empActualizado);
            return "Registro de empleado actualizado con éxito!";
        }
        return "Problemas al actualizar registro de empleado !(Faltan datos)";
    }

    @GetMapping(value="/obtenerLegajo/{id}")
    public long obtenerLegajo(@PathVariable long id){
        long legajo = 0;
        if (id != 0) {
            Empleado empleadoEncontrado = empleadoRepository.findById(id).get();
            legajo = empleadoEncontrado.getLegajo();

            return legajo;
        }
        return legajo;
    }

    @GetMapping(value="/obtenerSueldoBruto/{id}")
    public float obtenerSueldoBruto(@PathVariable long id){
        float sueldoBruto = 0;
        if (id != 0) {
            Empleado empleadoEncontrado = empleadoRepository.findById(id).get();
            sueldoBruto = empleadoEncontrado.getSueldoBruto();

            return sueldoBruto;
        }
        return sueldoBruto;
    }

    @GetMapping(value="/obtenerMontoAntiguedad/{id}")
    public int obtenerMontoAntiguedad(@PathVariable long id){
        //SI LA ANTIGUEDAD ES MENOR A UN AÑO, NO LE CORRESPONDE UN MONTO EXTRA
        //SI LA ANTIGUEDAD ES DE 1 a 3 AÑOS LE CORRESPONDEN $2000
        //SI LA ANTIGUEDAD ES DE 3 a 5 AÑOS LE CORRESPONDEN $3000
        //SI LA ANTIGUEDAD ES DE 5 a 10 AÑOS LE CORRESPONDEN $5000
        //SI LA ANTIGUEDAD ES MAYOR A 10 AÑOS LE CORRESPONDEN $9000
        int anios = 0;
        int monto = 0;
        if (id != 0) {
            Empleado empleadoEncontrado = empleadoRepository.findById(id).get();
            anios = calcularAniosDate(empleadoEncontrado.getFechaIngreso());
            if (anios < 1){
                monto = 0;
            }
            if (anios >= 1 && anios <= 3){
                monto = 2000;
            }
            if (anios >= 3 && anios <= 5){
                monto = 3000;
            }
            if (anios >= 5 && anios <= 10){
                monto = 5000;
            }
            if (anios >= 10){
                monto = 9000;
            }

            return monto;
        }
        return monto;
    }

    private int calcularAniosDate(Date fecha) {
        //Fecha actual
        Date actual = new Date();

        //Cojo los datos necesarios
        int diaActual = actual.getDate();
        int mesActual = actual.getMonth() + 1;
        int anioActual = actual.getYear() + 1900;

        //Diferencia de años
        int diferencia = anioActual - (fecha.getYear() + 1900);

        // Si la diferencia es diferencia a 0
        if (diferencia != 0) {

            //Si el mes actual es menor que el que me pasan le resto 1
            //Si el mes es igual y el dia que me pasan es mayor al actual le resto 1
            //Si el mes es igual y el dia que me pasan es menor al actual no le resto 1
            if (mesActual <= (fecha.getMonth() + 1)) { //si if (mesActual == (fecha.getMonth() + 1)) { if (fecha.getDate() > diaActual) {
                diferencia--;
            }
            } else {
            diferencia--;
        }
        return diferencia;
    }


}






