package com.example.dao;

import com.example.entity.WarnInfo;
import com.example.entity.WarnQuery;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

public interface WarnRuleDAO {
    WarnInfo getWarnInfo(WarnQuery query);
}
