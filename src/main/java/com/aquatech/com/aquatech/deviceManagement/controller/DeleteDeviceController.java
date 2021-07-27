package com.aquatech.com.aquatech.deviceManagement.controller;

import com.aquatech.com.aquatech.deviceManagement.interfaces.IDeviceService;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
public class DeleteDeviceController {
    private final IDeviceService deviceService;
    private final Logger logger = LogManager.getLogger(DeleteDeviceController.class);

    @Autowired
    public DeleteDeviceController(IDeviceService deviceService) {
        this.deviceService = deviceService;
    }
    @DeleteMapping("/deleteDevice/{id}")
    public Map<String, Object> deleteDevice(@PathVariable String id)throws Exception{
        Map<String,Object> response = new HashMap<>();
        Long dataId = Long.valueOf(id);
        try {
            response = deviceService.deleteDeviceById(dataId);
        }catch (Exception e){
            logger.error(ExceptionUtils.getStackTrace(e));
        }
        return response;
    }
}
