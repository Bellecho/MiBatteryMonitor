package com.example.dao;

import com.example.entity.Vehicle;

import java.util.List;

public interface VehicleDAO {
    void addVehicle(Vehicle vehicle);
    List<Vehicle> getAllVehicles();
}
