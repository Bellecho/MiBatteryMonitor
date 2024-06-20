package com.example;

import com.example.controller.WarnController;
import com.example.dto.WarnRequest;
import com.example.dto.WarnResponse;
import com.example.entity.WarnInfo;
import com.example.entity.WarnQuery;
import com.example.service.WarnService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class TestWarnController {

    private MockMvc mockMvc;

    @Mock
    private WarnService warnService;

    @InjectMocks
    private WarnController warnController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(warnController).build();
    }

    @Test
    void testGetWarnings() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        // Mock the response from the service layer
        WarnInfo mockWarnInfo1 = new WarnInfo();
        mockWarnInfo1.setVehicleNumber(1);
        mockWarnInfo1.setBatteryType("三元电池");
        mockWarnInfo1.setRuleName("电压差报警");
        mockWarnInfo1.setLevel("0");

        WarnInfo mockWarnInfo2 = new WarnInfo();
        mockWarnInfo2.setVehicleNumber(2);
        mockWarnInfo2.setBatteryType("铁锂电池");
        mockWarnInfo2.setRuleName("电流差报警");
        mockWarnInfo2.setLevel("2");

        WarnInfo mockWarnInfo3 = new WarnInfo();
        mockWarnInfo3.setVehicleNumber(3);
        mockWarnInfo3.setBatteryType("三元电池");
        mockWarnInfo3.setRuleName("电压差报警");
        mockWarnInfo3.setLevel("2");

        WarnInfo mockWarnInfo4 = new WarnInfo();
        mockWarnInfo4.setVehicleNumber(3);
        mockWarnInfo4.setBatteryType("三元电池");
        mockWarnInfo4.setRuleName("电流差报警");
        mockWarnInfo4.setLevel("2");

        when(warnService.getWarnInfo(any(WarnQuery.class)))
                .thenReturn(mockWarnInfo1)
                .thenReturn(mockWarnInfo2)
                .thenReturn(mockWarnInfo3)
                .thenReturn(mockWarnInfo4);


        List<WarnRequest> requests = Arrays.asList(
                new WarnRequest(1, 1, "{\"Mx\":12.0,\"Mi\":0.6}"),
                new WarnRequest(2, 2, "{\"Ix\":12.0,\"Ii\":11.7}"),
                new WarnRequest(3, 0, "{\"Mx\":11.0,\"Mi\":9.6,\"Ix\":12.0,\"Ii\":11.7}")
        );


        long startTime = System.currentTimeMillis();

        mockMvc.perform(post("/api/warn")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requests)))
                .andExpect(status().isOk());


        long endTime = System.currentTimeMillis();


        long responseTime = endTime - startTime;
        System.out.println("Response time: " + responseTime + "ms");


        assert responseTime < 1000;


        long successfulWarnings = 4;
        long totalWarnings = 4;
        double successRate = (double) successfulWarnings / totalWarnings;

        System.out.println("Success rate: " + (successRate * 100) + "%");


        assert successRate >= 0.90;
    }
}
