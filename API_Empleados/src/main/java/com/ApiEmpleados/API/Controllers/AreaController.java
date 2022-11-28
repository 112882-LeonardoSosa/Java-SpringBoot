package com.ApiEmpleados.API.Controllers;

import com.ApiEmpleados.API.Models.Area;
import com.ApiEmpleados.API.Repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AreaController {

    //inyeccion de Dependencia
    @Autowired
    private AreaRepository areaRepository;


    @GetMapping(value = "/getAreas")
    public List<Area> getTareas(){
        return areaRepository.findAll();
    }

    @PostMapping(value = "/saveArea")
    public String saveArea(@RequestBody Area area){
        if (area == null) {
            return "Error al guardar Área, faltan datos";
        }
        areaRepository.save(area);
        return "Area cargada con éxito!";
    }

    @DeleteMapping(value="/deleteArea/{id}")
    public boolean deleteArea(@PathVariable long id){
        if (id != 0) {
            Area areaEliminada = areaRepository.findById(id).get();
            areaRepository.delete(areaEliminada);
            return true;
        }
        return false;
    }

    @PutMapping(value="/update/{id}")
    public String updateTask(@PathVariable long id, @RequestBody Area area){
        if (area != null && id != 0) {
            Area areaActualizada = areaRepository.findById(id).get();
            areaActualizada.setNombre(area.getNombre());
            areaRepository.save(areaActualizada);
            return "Área actualizada con éxito!";
        }
        return "Problemas al actualizar el área!(Faltan datos)";
    }


}
