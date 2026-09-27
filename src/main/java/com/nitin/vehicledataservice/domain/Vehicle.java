package com.nitin.vehicledataservice.domain;

import jakarta.validation.constraints.NotBlank;

public class Vehicle {
    @NotBlank
    private String vehicleId;
    @NotBlank
    private String type;

    public Vehicle(String vehicleId, String type) {
        this.vehicleId = vehicleId;
        this.type = type;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getType() {
        return type;
    }
}
