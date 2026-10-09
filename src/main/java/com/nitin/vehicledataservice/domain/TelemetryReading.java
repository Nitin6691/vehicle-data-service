package com.nitin.vehicledataservice.domain;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;

public class TelemetryReading {
    private static final int CRITICAL_BATTERY_THRESHOLD = 20;
    @NotBlank(message = "vehicle id is required")
    private final String vehicleId;
    @Min(value = 0, message = "speed cannot be negative")
    @NotNull(message = "speed is required")
    private final Integer speed;
    @Min(value = 0, message = "battery level cannot be negative")
    @Max(value = 100, message = "battery level cannot be more than 100%")
    @NotNull(message = "battery level is required")
    private final Integer batteryLevel;
    @NotNull(message = "recorded at time is required")
    private final Instant recordedAt;


    public TelemetryReading(String vehicleId, Integer speed, Integer batteryLevel, Instant recordedAt) {
        this.vehicleId = vehicleId;
        this.speed = speed;
        this.batteryLevel = batteryLevel;
        this.recordedAt = recordedAt;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public Integer getSpeed() {
        return speed;
    }

    public Integer getBatteryLevel() {
        return batteryLevel;
    }

    public Instant getRecordedAt() {
        return recordedAt;
    }

    public boolean isCriticalBattery() {
        return batteryLevel < CRITICAL_BATTERY_THRESHOLD;
    }
}
