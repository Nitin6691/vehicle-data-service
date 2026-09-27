package com.nitin.vehicledataservice.dto;

public class TelemetryReadingResponse {
        private final Long id;
        private final String vehicleId;
        private final int speed;
        private final int batteryLevel;

        public TelemetryReadingResponse(Long id, String vehicleId, int speed, int batteryLevel){
            this.id = id;
            this.vehicleId = vehicleId;
            this.speed = speed;
            this.batteryLevel = batteryLevel;
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
    }

