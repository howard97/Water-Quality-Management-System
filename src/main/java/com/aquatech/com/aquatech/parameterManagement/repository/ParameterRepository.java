package com.aquatech.com.aquatech.parameterManagement.repository;

import com.aquatech.com.aquatech.parameterManagement.model.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParameterRepository extends JpaRepository<Parameter, Long> {
}
