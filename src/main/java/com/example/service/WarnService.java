package com.example.service;

import com.example.entity.WarnInfo;
import com.example.entity.WarnQuery;

import java.util.List;

public interface WarnService {
    WarnInfo getWarnInfo(WarnQuery query);
}
