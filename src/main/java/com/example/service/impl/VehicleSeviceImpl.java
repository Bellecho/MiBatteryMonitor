package com.example.service.impl;

import com.example.dao.VehicleDAO;
import com.example.entity.Vehicle;
import com.example.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class VehicleSeviceImpl implements VehicleService {
    @Autowired
    private VehicleDAO vehicleDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void addVehicle(Vehicle vehicle) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String randomString = uuid.substring(0, 16);
        vehicle.setVid(randomString);
        vehicleDao.addVehicle(vehicle);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Vehicle> getAllVehicles(){
        return vehicleDao.getAllVehicles();
    }
}
