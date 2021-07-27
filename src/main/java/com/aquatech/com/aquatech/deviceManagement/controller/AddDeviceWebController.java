package com.aquatech.com.aquatech.deviceManagement.controller;

import com.aquatech.com.aquatech.deviceManagement.interfaces.IDeviceService;
import com.aquatech.com.aquatech.deviceManagement.model.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AddDeviceWebController {
    private final IDeviceService deviceService;

    @Autowired
    public AddDeviceWebController(IDeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping("/addDevice")
    public String displayDevice(){
        return "deviceManagement/addDevice";
    }

    @GetMapping("/listOfDevices")
    public String displayListOfDevices(Model model){
        List<Device> devices = deviceService.getAllDevices();
        model.addAttribute("devices", devices);
        return "deviceManagement/listOfDevices";
    }
}
