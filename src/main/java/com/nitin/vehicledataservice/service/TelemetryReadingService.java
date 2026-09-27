package com.nitin.vehicledataservice.service;

import com.nitin.vehicledataservice.domain.TelemetryReading;
import com.nitin.vehicledataservice.dto.TelemetryReadingResponse;
import com.nitin.vehicledataservice.entity.TelemetryReadingEntity;
import com.nitin.vehicledataservice.entity.VehicleEntity;
import com.nitin.vehicledataservice.exception.VehicleNotFoundException;
import com.nitin.vehicledataservice.repository.TelemetryReadingRepository;
import com.nitin.vehicledataservice.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TelemetryReadingService {
    private final TelemetryReadingRepository telemetryReadingRepository;
    private final VehicleRepository vehicleRepository;

    public TelemetryReadingService(TelemetryReadingRepository telemetryReadingRepository, VehicleRepository vehicleRepository) {
        this.telemetryReadingRepository = telemetryReadingRepository;
        this.vehicleRepository = vehicleRepository;
    }

    public TelemetryReadingEntity save(TelemetryReading telemetryReading) {
        VehicleEntity vehicle = vehicleRepository.findByVehicleId(telemetryReading.getVehicleId())
                .orElseThrow(() -> new VehicleNotFoundException("Vehicle "+telemetryReading.getVehicleId()+" does not exist in Database"));

        return telemetryReadingRepository.save(new TelemetryReadingEntity(
                vehicle,
                telemetryReading.getSpeed(),
                telemetryReading.getBatteryLevel()));
    }

    public List<TelemetryReadingResponse> getReadingByVehicleId(String vehicleId) {
        List<TelemetryReadingResponse> responseList = new ArrayList<>();
        List<TelemetryReadingEntity> entityList = telemetryReadingRepository.findByVehicle_VehicleId(vehicleId);

        for (TelemetryReadingEntity entity : entityList){
            responseList.add(
                    new TelemetryReadingResponse(
                            entity.getId(),
                            entity.getVehicle().getVehicleId(),
                            entity.getSpeed(),
                            entity.getBatteryLevel()
                    )
            );
        }
        return responseList;
    }

    public List<TelemetryReadingResponse> findAllReadings() {
        List<TelemetryReadingResponse> responseList = new ArrayList<>();
        List<TelemetryReadingEntity> entityList = telemetryReadingRepository.findAll();

        for (TelemetryReadingEntity entity : entityList){
            responseList.add(
                    new TelemetryReadingResponse(
                            entity.getId(),
                            entity.getVehicle().getVehicleId(),
                            entity.getSpeed(),
                            entity.getBatteryLevel()
                    )
            );
        }
        return responseList;
    }
}

