package com.nitin.vehicledataservice.service;

import com.nitin.vehicledataservice.domain.Vehicle;
import com.nitin.vehicledataservice.dto.VehicleResponse;
import com.nitin.vehicledataservice.entity.VehicleEntity;
import com.nitin.vehicledataservice.exception.DuplicateVehicleException;
import com.nitin.vehicledataservice.repository.VehicleRepository;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public VehicleResponse saveVehicle(Vehicle vehicle){
        if(!vehicleRepository.existsByVehicleId(vehicle.getVehicleId())) {
            VehicleEntity vehicleEntity = new VehicleEntity(
                    vehicle.getVehicleId(),
                    vehicle.getType()
            );
            return VehicleResponse.from(vehicleRepository.save(vehicleEntity));
        }else {
            throw new DuplicateVehicleException("Vehicle already exists in DB");
        }
    }
}
