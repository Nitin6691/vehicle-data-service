package com.nitin.vehicledataservice.service;

import com.nitin.vehicledataservice.domain.TelemetryReading;
import com.nitin.vehicledataservice.dto.TelemetryReadingResponse;
import com.nitin.vehicledataservice.entity.TelemetryReadingEntity;
import com.nitin.vehicledataservice.entity.VehicleEntity;
import com.nitin.vehicledataservice.exception.VehicleNotFoundException;
import com.nitin.vehicledataservice.repository.TelemetryReadingRepository;
import com.nitin.vehicledataservice.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class TelemetryReadingService {
    private final TelemetryReadingRepository telemetryReadingRepository;
    private final VehicleRepository vehicleRepository;

    public TelemetryReadingService(TelemetryReadingRepository telemetryReadingRepository, VehicleRepository vehicleRepository) {
        this.telemetryReadingRepository = telemetryReadingRepository;
        this.vehicleRepository = vehicleRepository;
    }

    public TelemetryReadingResponse save(TelemetryReading telemetryReading) {
        VehicleEntity vehicle = vehicleRepository.findByVehicleId(telemetryReading.getVehicleId())
                .orElseThrow(() -> new VehicleNotFoundException("Vehicle "+telemetryReading.getVehicleId()+" does not exist in Database"));

        TelemetryReadingEntity entity =  telemetryReadingRepository.save(new TelemetryReadingEntity(
                vehicle,
                telemetryReading.getSpeed(),
                telemetryReading.getBatteryLevel(),
                telemetryReading.getRecordedAt()));

        return TelemetryReadingResponse.from(entity);
    }

    public List<TelemetryReadingResponse> getReadingsByVehicleId(String vehicleId) {
        List<TelemetryReadingEntity> entityList = telemetryReadingRepository.findByVehicle_VehicleId(vehicleId);
        List<TelemetryReadingResponse> responseList = entityList.stream().map(TelemetryReadingResponse::from).toList();
        return responseList;
    }

    public List<TelemetryReadingResponse> findAllReadings() {
        List<TelemetryReadingEntity> entityList = telemetryReadingRepository.findAll();
        List<TelemetryReadingResponse> responseList = entityList.stream().map(TelemetryReadingResponse::from).toList();
        return responseList;
    }
}

