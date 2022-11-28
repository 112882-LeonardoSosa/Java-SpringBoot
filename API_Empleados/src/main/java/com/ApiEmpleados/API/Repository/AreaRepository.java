package com.ApiEmpleados.API.Repository;

import com.ApiEmpleados.API.Models.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaRepository extends JpaRepository<Area, Long> {

}
