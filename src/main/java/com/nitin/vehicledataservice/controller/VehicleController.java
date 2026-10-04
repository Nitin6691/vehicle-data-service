package com.nitin.vehicledataservice.controller;

import com.nitin.vehicledataservice.domain.Vehicle;
import com.nitin.vehicledataservice.dto.VehicleResponse;
import com.nitin.vehicledataservice.entity.VehicleEntity;
import com.nitin.vehicledataservice.service.VehicleService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    public ResponseEntity<VehicleResponse> addVehicle(@RequestBody @Valid Vehicle vehicle){
        VehicleResponse vehicleResponse = vehicleService.saveVehicle(vehicle);
        return ResponseEntity.status(HttpStatus.CREATED).body(vehicleResponse);
    }
}
