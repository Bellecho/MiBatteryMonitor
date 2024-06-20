package com.example.service;

import com.example.entity.Vehicle;

import java.util.List;

public interface VehicleService {
    void addVehicle(Vehicle vehicle);
    List<Vehicle> getAllVehicles();
}
