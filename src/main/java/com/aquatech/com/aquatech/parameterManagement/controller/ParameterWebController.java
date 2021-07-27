package com.aquatech.com.aquatech.parameterManagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ParameterWebController {
    @GetMapping("/addParameter")
    public String displayParameter(){
        return "parameterManagement/addParameter";
    }

    @GetMapping("/uploadParameter")
    public String displayUploadParameter(){
        return "parameterManagement/uploadParameters";
    }

}
