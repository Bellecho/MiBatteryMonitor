package com.example.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class WarnQuery  {
    private int vid;
    private int wid;
    private double sub;
    private int type;
}
