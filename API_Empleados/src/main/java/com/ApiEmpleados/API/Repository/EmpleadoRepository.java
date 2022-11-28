package com.ApiEmpleados.API.Repository;

import com.ApiEmpleados.API.Models.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository  extends JpaRepository<Empleado, Long> {

}
