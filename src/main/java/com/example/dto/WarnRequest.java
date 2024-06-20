package com.example.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class WarnRequest  {
    private int carId;
    private int warnId;
    private String signal;

    public WarnRequest() {
    }

    public WarnRequest(int carId, int warnId, String signal) {
        this.carId = carId;
        this.warnId = warnId;
        this.signal = signal;
    }
}
