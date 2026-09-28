package com.nitin.vehicledataservice.repository;

import com.nitin.vehicledataservice.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VehicleRepository extends JpaRepository<VehicleEntity, Long> {

    Optional<VehicleEntity> findByVehicleId(String vehicleId);
    boolean existsByVehicleId(String vehicleId);
}
