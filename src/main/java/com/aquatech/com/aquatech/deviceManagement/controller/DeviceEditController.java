package com.aquatech.com.aquatech.deviceManagement.controller;

import com.aquatech.com.aquatech.deviceManagement.interfaces.IDeviceService;
import com.aquatech.com.aquatech.deviceManagement.model.Device;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DeviceEditController {
    private final IDeviceService deviceService;
    private Logger logger = LogManager.getLogger(DeviceEditController.class);

    @Autowired
    public DeviceEditController(IDeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping("/editDevice")
    public String displayEditDevice(@RequestParam("id") Long id, Model model)throws Exception{
        Device device = null;
        try{
            device = deviceService.getDeviceById(id);
        }catch (Exception e){
            logger.error(e.getMessage(),e.getCause());
        }
        model.addAttribute("device", device);
        return "deviceManagement/deviceModification/deviceEdit";
    }
}
