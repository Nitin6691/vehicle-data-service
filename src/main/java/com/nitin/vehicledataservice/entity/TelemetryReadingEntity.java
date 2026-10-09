package com.nitin.vehicledataservice.entity;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table (indexes = @Index(name = "idx_telemetry_vehicle_ref", columnList = "vehicle_ref"))
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
    @Column(nullable = false)
    private Instant recordedAt;
    @Column(nullable = false)
    private Instant receivedAt;

    protected TelemetryReadingEntity() {
    }

    public TelemetryReadingEntity(VehicleEntity vehicle, int speed, int batteryLevel, Instant recordedAt) {
        this.vehicle = vehicle;
        this.speed = speed;
        this.batteryLevel = batteryLevel;
        this.recordedAt = recordedAt;
        this.receivedAt = Instant.now();
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

    public Instant getRecordedAt() {
        return recordedAt;
    }

    public Instant getReceivedAt() {
        return receivedAt;
    }
}
