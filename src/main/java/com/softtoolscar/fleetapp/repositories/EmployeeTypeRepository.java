package com.softtoolscar.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.softtoolscar.fleetapp.models.EmployeeType;


@Repository
public interface EmployeeTypeRepository extends JpaRepository<EmployeeType, Integer> {

}
