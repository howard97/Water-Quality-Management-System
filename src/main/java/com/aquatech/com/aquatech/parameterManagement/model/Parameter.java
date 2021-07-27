package com.aquatech.com.aquatech.parameterManagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
public class Parameter {
    @Id
    public Long deviceId;
    public String temperature;
    public String pH;
    public String turbidity;
    public String conductivity;

    public Parameter(String temperature, String pH, String turbidity, String conductivity) {
        this.temperature = temperature;
        this.pH = pH;
        this.turbidity = turbidity;
        this.conductivity = conductivity;
    }
}
