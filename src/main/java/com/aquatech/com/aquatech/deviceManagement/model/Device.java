package com.aquatech.com.aquatech.deviceManagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Device {
    @Id
    @SequenceGenerator(name = "device_sequence",
            sequenceName = "device_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "device_sequence")
    public Long id;
    public String deviceName;
    public String deviceLocation;
    public String gpsLongitude;
    public String gpsLatitude;

    public Device(String deviceLocation, String gpsLongitude, String gpsLatitude) {
        this.deviceLocation = deviceLocation;
        this.gpsLongitude = gpsLongitude;
        this.gpsLatitude = gpsLatitude;
    }
}
