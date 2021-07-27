package com.aquatech.com.aquatech.deviceManagement.interfaces;

import com.aquatech.com.aquatech.deviceManagement.dto.DeviceDto;
import com.aquatech.com.aquatech.deviceManagement.model.Device;

import java.util.List;
import java.util.Map;

public interface IDeviceService {
    Map<String, Object> saveDeviceData(DeviceDto formDto);
    List<Device> getAllDevices();
    Device getDeviceById(Long id);

    Map<String, Object> deleteDeviceById(Long id);
}

