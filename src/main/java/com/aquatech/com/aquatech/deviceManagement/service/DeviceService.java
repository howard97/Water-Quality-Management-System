package com.aquatech.com.aquatech.deviceManagement.service;

import com.aquatech.com.aquatech.commons.exceptions.CustomsException;
import com.aquatech.com.aquatech.commons.exceptions.ErrorCode;
import com.aquatech.com.aquatech.deviceManagement.dto.DeviceDto;
import com.aquatech.com.aquatech.deviceManagement.interfaces.IDeviceService;
import com.aquatech.com.aquatech.deviceManagement.model.Device;
import com.aquatech.com.aquatech.deviceManagement.repository.DeviceRepository;
import com.aquatech.com.aquatech.parameterManagement.enums.Responses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class DeviceService implements IDeviceService {
    private final DeviceRepository deviceRepository;

    @Autowired
    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    /**
     * method to save device data
     */
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public Map<String, Object> saveDeviceData(DeviceDto formDto) {
        Map<String, Object> response = new HashMap<>();
        if(deviceNameExists(formDto.getDeviceName())){
            response.put( Responses.ResponseHeaderStatus, Responses.ResponseStatusError );
            response.put( Responses.ResponseHeaderMessage, "Device is already in the system!" );
            response.put( Responses.ResponseHeaderData, 507 );
            return response;
        }
        Device device = new Device();
        device.setDeviceName(formDto.getDeviceName());
        device.setDeviceLocation(formDto.getDeviceLocation());
        device.setGpsLatitude(formDto.getGpsLatitude());
        device.setGpsLongitude(formDto.getGpsLongitude());
        Device device2 = deviceRepository.save(device);
        if(device2 != null){
            response.put( Responses.ResponseHeaderStatus, Responses.ResponseStatusSuccess );
            response.put( Responses.ResponseHeaderMessage, "Device Data has successfully been submitted!" );
            response.put( Responses.ResponseHeaderData, 1 );
        }else {
            response.put( Responses.ResponseHeaderStatus, Responses.ResponseStatusError );
            response.put( Responses.ResponseHeaderMessage, "Error Submitting Device Data!" );
            response.put( Responses.ResponseHeaderData, 504 );
        }
        return response;
    }


    @Override
    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    @Override
    public Device getDeviceById(Long id) {
        return deviceRepository.getOne(id);
    }
    /**
     * method to check if deviceNameExists
     *
     */
    public boolean deviceNameExists(String deviceName) {
        long countOfAccounts = deviceRepository.countDeviceName(deviceName);
        return countOfAccounts != 0;
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public Map<String, Object> deleteDeviceById(Long id) {
        Map<String, Object> response = new HashMap<>();
        Device device = deviceRepository.getOne(id);
        if(device == null){
            throw new CustomsException("DEVICE NOT FOUND", ErrorCode.ERR_602);
        }
        if(device != null){
            deviceRepository.delete(device);
            response.put( Responses.ResponseHeaderStatus, Responses.ResponseStatusSuccess );
            response.put( Responses.ResponseHeaderMessage, "Device has successfully been deleted!" );
            response.put( Responses.ResponseHeaderData, 1 );
        }else{
            response.put( Responses.ResponseHeaderStatus, Responses.ResponseStatusError );
            response.put( Responses.ResponseHeaderMessage, "Error deleting your Device!" );
            response.put( Responses.ResponseHeaderData, 504 );
        }
        return response;
    }
}
