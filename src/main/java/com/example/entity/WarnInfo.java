package com.example.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class WarnInfo  implements Serializable {
    private int vehicleNumber;
    private String batteryType;
    private String ruleName;
    private String level;
}
