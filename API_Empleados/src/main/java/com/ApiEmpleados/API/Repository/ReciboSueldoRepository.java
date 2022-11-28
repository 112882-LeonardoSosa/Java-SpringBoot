package com.ApiEmpleados.API.Repository;

import com.ApiEmpleados.API.Dtos.DtoRecibo;
import com.ApiEmpleados.API.Models.ReciboSueldo;
import org.hibernate.mapping.Any;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Tuple;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReciboSueldoRepository extends JpaRepository<ReciboSueldo, Long> {

    @Query("select new com.ApiEmpleados.API.Dtos.DtoRecibo (a.nombre, sum(r.sueldoNeto)) from ReciboSueldo r " +
            "join Empleado e on e.legajo = r.legajo " +
            "join Area a on a.id = e.area.id " +
            "where r.mes = :mes and r.anio = :anio " +
            "group by a.nombre")
    public List<DtoRecibo> getReporteArea(@Param("anio") Integer anio, @Param("mes") Integer mes);

}
