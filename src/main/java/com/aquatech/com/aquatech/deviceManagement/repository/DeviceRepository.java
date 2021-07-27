package com.aquatech.com.aquatech.deviceManagement.repository;

import com.aquatech.com.aquatech.deviceManagement.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
    Device findByDeviceName(String deviceName);
    @Query("SELECT COUNT(u) FROM Device u WHERE u.deviceName = ?1")
    long countDeviceName(String deviceNamer);
}
