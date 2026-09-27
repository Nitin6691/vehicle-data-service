package com.nitin.vehicledataservice.entity;

import jakarta.persistence.*;

@Entity
public class TelemetryReadingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_ref", nullable = false)
    private VehicleEntity vehicle;

    @Column(nullable = false)
    private int speed;
    @Column(nullable = false)
    private int batteryLevel;

    protected TelemetryReadingEntity() {
    }

    public TelemetryReadingEntity(VehicleEntity vehicle, int speed, int batteryLevel) {
        this.vehicle = vehicle;
        this.speed = speed;
        this.batteryLevel = batteryLevel;
    }

    public Long getId() {
        return id;
    }

    public VehicleEntity getVehicle() {
        return vehicle;
    }

    public int getSpeed() {
        return speed;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }
}
