package com.example.dto;

import com.example.entity.WarnInfo;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@Accessors(chain = true)
public class WarnResponse  {
    private int code;
    private String message;
    private List<WarnInfo> data;
}
