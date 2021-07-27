package com.aquatech.com.aquatech.deviceManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceDto {
    @NotNull(message = "Device Name is Required")
    public String deviceName;
    @NotNull(message = "Device Location is Required")
    public String deviceLocation;
    @NotNull(message = "GPS Longitude is Required")
    public String gpsLongitude;
    @NotNull(message = "GPS Latitude Required")
    public String gpsLatitude;
}
