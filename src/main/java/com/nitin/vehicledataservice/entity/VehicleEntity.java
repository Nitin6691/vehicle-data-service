package com.nitin.vehicledataservice.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class VehicleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String vehicleId;
    @Column(nullable = false)
    private String type;

    @OneToMany(mappedBy = "vehicle")
    private List<TelemetryReadingEntity> readings;

    protected VehicleEntity(){}

    public VehicleEntity(String vehicleId, String type) {
        this.vehicleId = vehicleId;
        this.type = type;
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

    public void addReading(TelemetryReadingEntity telemetryReading){
        this.readings.add(telemetryReading);
    }
}
