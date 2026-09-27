package com.nitin.vehicledataservice.repository;

import com.nitin.vehicledataservice.entity.TelemetryReadingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TelemetryReadingRepository extends JpaRepository<TelemetryReadingEntity, Long> {

//    @Query("SELECT t from TelemetryReadingEntity t join fetch VehicleEntity v where v.vehicleId = vehicleId")
    List<TelemetryReadingEntity> findByVehicle_VehicleId(String vehicleId);
}
