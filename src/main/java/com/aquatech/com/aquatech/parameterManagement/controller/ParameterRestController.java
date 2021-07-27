package com.aquatech.com.aquatech.parameterManagement.controller;

import com.aquatech.com.aquatech.parameterManagement.dto.ParameterDto;
import com.aquatech.com.aquatech.parameterManagement.enums.Responses;
import com.aquatech.com.aquatech.parameterManagement.interfaces.IParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParameterRestController {
    private final IParameterService parameterService;
    private Logger logger = LogManager.getLogger(ParameterRestController.class);
    @Autowired
    public ParameterRestController(IParameterService parameterService) {
        this.parameterService = parameterService;
    }

    /**
     * method to submitParameterData
     *
     */
    @PostMapping("/submitParameterData")
    public Map<String, Object> submitParameterData(@RequestBody ParameterDto formDto, BindingResult result) throws Exception{
     Map<String, Object> response = new HashMap<>();
     if (result.hasErrors()) {

         response.put( Responses.ResponseHeaderStatus, Responses.ResponseStatusError );
         response.put( Responses.ResponseHeaderMessage, "Invalid Inputs Error" );
         response.put( Responses.ResponseHeaderData, 500 );
         response.put( "payload", result.getAllErrors() );
         return response;
     }
     try {
         response = parameterService.saveAllParameters(formDto);
         return response;
     }catch (Exception e){
        logger.error(e.getMessage(),e.getCause());
         response.put( Responses.ResponseHeaderStatus, Responses.ResponseStatusError );
         response.put( Responses.ResponseHeaderMessage, "Error SSubmitting Parameter Data!" );
         response.put( Responses.ResponseHeaderData, 401);
     }
     return response;
 }
}
