package com.nitin.vehicledataservice.dto;

import com.nitin.vehicledataservice.entity.TelemetryReadingEntity;

import java.time.Instant;

public class TelemetryReadingResponse {
    private final Long id;
    private final String vehicleId;
    private final int speed;
    private final int batteryLevel;
    private final Instant recordedAt;
    private final Instant receivedAt;

    public TelemetryReadingResponse(Long id, String vehicleId, int speed, int batteryLevel, Instant recordedAt, Instant receivedAt) {
        this.id = id;
        this.vehicleId = vehicleId;
        this.speed = speed;
        this.batteryLevel = batteryLevel;
        this.recordedAt = recordedAt;
        this.receivedAt = receivedAt;
    }


    public static TelemetryReadingResponse from(TelemetryReadingEntity entity) {
        return new TelemetryReadingResponse(
                entity.getId(),
                entity.getVehicle().getVehicleId(),
                entity.getSpeed(),
                entity.getBatteryLevel(),
                entity.getRecordedAt(),
                entity.getReceivedAt()
        );
    }


    public Long getId() {
        return id;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public int getSpeed() {
        return speed;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public Instant getRecordedAt() {
        return recordedAt;
    }

    public Instant getReceivedAt() {
        return receivedAt;
    }
}

