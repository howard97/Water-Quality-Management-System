package com.aquatech.com.aquatech.parameterManagement.service;

import com.aquatech.com.aquatech.deviceManagement.model.Device;
import com.aquatech.com.aquatech.deviceManagement.repository.DeviceRepository;
import com.aquatech.com.aquatech.parameterManagement.dto.ParameterDto;
import com.aquatech.com.aquatech.parameterManagement.enums.Responses;
import com.aquatech.com.aquatech.parameterManagement.interfaces.IParameterService;
import com.aquatech.com.aquatech.parameterManagement.model.Parameter;
import com.aquatech.com.aquatech.parameterManagement.repository.ParameterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class ParameterService implements IParameterService {
    private final ParameterRepository parameterRepository;
    private final DeviceRepository deviceRepository;

    @Autowired
    public ParameterService(ParameterRepository parameterRepository, DeviceRepository deviceRepository) {
        this.parameterRepository = parameterRepository;
        this.deviceRepository = deviceRepository;
    }

    /**
     * method to saveAllParameters
     *
     */
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public Map<String, Object> saveAllParameters(ParameterDto formDto) {
        Map<String,Object> response = new HashMap<>();
        Device device = deviceRepository.findByDeviceName(formDto.getDeviceName());
        if(device == null){
            response.put( Responses.ResponseHeaderStatus, Responses.ResponseStatusError );
            response.put( Responses.ResponseHeaderMessage, "Oops! Device Name not found. Kindly insert the device on the systems!" );
            response.put( Responses.ResponseHeaderData, 404 );
            return response;
        }
        Parameter parameter = new Parameter();
        parameter.setDeviceId(device.getId());
        parameter.setTemperature(formDto.getTemperature());
        parameter.setConductivity(formDto.getConductivity());
        parameter.setPH(formDto.getPH());
        parameter.setTurbidity(formDto.getTurbidity());
        Parameter param = parameterRepository.save(parameter);
        if(param != null){
            response.put( Responses.ResponseHeaderStatus, Responses.ResponseStatusSuccess );
            response.put( Responses.ResponseHeaderMessage, "Parameter Data has successfully been submitted!" );
            response.put( Responses.ResponseHeaderData, 1 );
        }else {
            response.put( Responses.ResponseHeaderStatus, Responses.ResponseStatusError );
            response.put( Responses.ResponseHeaderMessage, "Error Submitting Parameter Data!" );
            response.put( Responses.ResponseHeaderData, 504 );
        }
        return response;
    }
}
