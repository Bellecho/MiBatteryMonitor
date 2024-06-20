package com.example.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class Vehicle  implements Serializable {
    private String vid;
    private int vehicleNumber;
    private String batteryType;
    private int totalMileage;
    private int batteryHealthStatus;
}

