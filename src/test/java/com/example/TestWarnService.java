package com.example;

import com.example.entity.WarnInfo;
import com.example.entity.WarnQuery;
import com.example.service.WarnService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest(classes = MiBatteryMonitorApplication.class)
@ContextConfiguration(classes = MiBatteryMonitorApplication.class)
public class TestWarnService {
    @Autowired
    private WarnService warnService;

    @Test
    public void testWarn() {
        WarnQuery query = new WarnQuery();
        query.setVid(2);
        query.setWid(2);
        query.setSub(0.8);
        query.setType(2);
        WarnInfo warnInfo1 = warnService.getWarnInfo(query);
        System.out.println(warnInfo1);
        WarnInfo warnInfo2 = warnService.getWarnInfo(query);
        System.out.println(warnInfo2);
    }
}
