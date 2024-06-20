package com.example.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class WarnRule implements Serializable {
    private int rid;
    private String batteryType;
    private double lower;
    private double upper;
    private String warnLevel;
}
