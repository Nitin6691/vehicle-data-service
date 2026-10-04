package com.nitin.vehicledataservice.controller;

import com.nitin.vehicledataservice.domain.TelemetryReading;
import com.nitin.vehicledataservice.dto.TelemetryReadingResponse;
import com.nitin.vehicledataservice.service.TelemetryReadingService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/telemetry")
public class TelemetryReadingController {
    private final TelemetryReadingService telemetryReadingService;
    public TelemetryReadingController(TelemetryReadingService telemetryReadingService){
        this.telemetryReadingService = telemetryReadingService;
    }

    @PostMapping
    public ResponseEntity<TelemetryReadingResponse> saveTelemetryReading(@Valid @RequestBody TelemetryReading telemetryReading){
        TelemetryReadingResponse telemetryReadingResponse = telemetryReadingService.save(telemetryReading);
        return ResponseEntity.status(HttpStatus.CREATED).body(telemetryReadingResponse);
    }

    @GetMapping("/vehicles/{vehicleId}")
    public List<TelemetryReadingResponse> getReadingsByVehicleId(@PathVariable String vehicleId){
        return telemetryReadingService.getReadingsByVehicleId(vehicleId);
    }

    @GetMapping
    public List<TelemetryReadingResponse> getAllReadings(){
        return telemetryReadingService.findAllReadings();
    }
}
