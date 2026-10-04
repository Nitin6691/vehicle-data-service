package com.nitin.vehicledataservice.dto;

import com.nitin.vehicledataservice.entity.VehicleEntity;

public class VehicleResponse {
    private final Long id;
    private final String vehicleId;
    private final String type;

    public VehicleResponse(Long id, String vehicleId, String type) {
        this.id = id;
        this.vehicleId = vehicleId;
        this.type = type;
    }

    public static VehicleResponse from (VehicleEntity entity){
        return new VehicleResponse(
                entity.getId(),
                entity.getVehicleId(),
                entity.getType()
        );
    }

    public Long getId() {
        return id;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getType() {
        return type;
    }
}
