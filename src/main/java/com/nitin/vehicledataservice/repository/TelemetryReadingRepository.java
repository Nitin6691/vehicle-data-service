package com.nitin.vehicledataservice.repository;

import com.nitin.vehicledataservice.entity.TelemetryReadingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TelemetryReadingRepository extends JpaRepository<TelemetryReadingEntity, Long> {
List<TelemetryReadingEntity> findByVehicle_VehicleId(String vehicleId);
}
