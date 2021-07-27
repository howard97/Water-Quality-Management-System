package com.aquatech.com.aquatech.parameterManagement.interfaces;

import com.aquatech.com.aquatech.parameterManagement.dto.ParameterDto;

import java.util.Map;

public interface IParameterService {
    Map<String, Object> saveAllParameters(ParameterDto formDto);
}
