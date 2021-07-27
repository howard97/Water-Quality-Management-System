package com.aquatech.com.aquatech.parameterManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParameterDto {
    @NotNull(message = "deviceName is Required")
    public String deviceName;
    @NotNull(message = "temperature is Required")
    public String temperature;
    @NotNull(message = "pH is Required")
    public String pH;
    @NotNull(message = "turbidity is Required")
    public String turbidity;
    @NotNull(message = "conductivity is Required")
    public String conductivity;
}
