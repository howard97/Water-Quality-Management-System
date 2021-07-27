package com.aquatech.com.aquatech.deviceManagement.controller;

import com.aquatech.com.aquatech.deviceManagement.dto.DeviceDto;
import com.aquatech.com.aquatech.deviceManagement.interfaces.IDeviceService;
import com.aquatech.com.aquatech.parameterManagement.enums.Responses;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AddDeviceRestController {
    private final IDeviceService deviceService;
    private Logger logger = LogManager.getLogger(AddDeviceRestController.class);

    @Autowired
    public AddDeviceRestController(IDeviceService deviceService) {
        this.deviceService = deviceService;
    }

    /**
     * method to submitDeviceDat
     *
     */
    @PostMapping("/submitDeviceData")
    public Map<String, Object> submitDeviceData(@Valid @RequestBody DeviceDto formDto, BindingResult result)throws Exception{
        Map<String, Object> response = new HashMap<>();
        if (result.hasErrors()) {
            response.put( Responses.ResponseHeaderStatus, Responses.ResponseStatusError );
            response.put( Responses.ResponseHeaderMessage, "Enter all inputs in a correct format." );
            response.put( Responses.ResponseHeaderData, 500 );
            response.put( "payload", result.getAllErrors() );
            return response;
        }
        try {
            response = deviceService.saveDeviceData(formDto);
        }catch (Exception e){
            logger.error(e.getMessage(), e.getCause());
            response.put( Responses.ResponseHeaderStatus, Responses.ResponseStatusError );
            response.put( Responses.ResponseHeaderMessage, "Error Submitting Device Data!" );
            response.put( Responses.ResponseHeaderData, 401);
        }
        return response;
    }
}
