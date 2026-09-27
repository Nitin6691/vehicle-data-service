package com.nitin.vehicledataservice.domain;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class TelemetryReading {
    private static final int CRITICAL_BATTERY_THRESHOLD = 20;
    private final String vehicleId;
    @Min(value = 0, message = "speed cannot be negative")
    private final int speed;
    @Min(value = 0, message = "battery level cannot be negative")
    @Max(value = 100, message = "battery level cannot be more than 100%")
    private final int batteryLevel;

    public TelemetryReading(String vehicleId, int speed, int batteryLevel){
        this.vehicleId = vehicleId;
        this.speed = speed;
        this.batteryLevel = batteryLevel;
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

    public boolean isCriticalBattery(){
        return batteryLevel < CRITICAL_BATTERY_THRESHOLD;
    }
}
