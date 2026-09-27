package com.nitin.vehicledataservice.service;

import com.nitin.vehicledataservice.domain.Vehicle;
import com.nitin.vehicledataservice.entity.VehicleEntity;
import com.nitin.vehicledataservice.repository.VehicleRepository;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public VehicleEntity saveVehicle(Vehicle vehicle){
        VehicleEntity vehicleEntity = new VehicleEntity(
                vehicle.getVehicleId(),
                vehicle.getType()
        );
        return vehicleRepository.save(vehicleEntity);
    }
}
