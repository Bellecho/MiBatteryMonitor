package com.example.controller;

import com.example.dto.WarnRequest;
import com.example.dto.WarnResponse;
import com.example.entity.WarnInfo;
import com.example.entity.WarnQuery;
import com.example.service.WarnService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class WarnController {

    private static final Logger LOGGER = Logger.getLogger(WarnController.class.getName());

    @Autowired
    private WarnService warnService;

    @PostMapping("/warn")
    public WarnResponse getWarnings(@RequestBody List<WarnRequest> requests) {
        List<WarnInfo> warnInfos = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();

        for (WarnRequest request : requests) {
            try {
                Map<String, Object> signalMap = mapper.readValue(request.getSignal(), Map.class);

                // Process "Mx - Mi"
                if (signalMap.containsKey("Mx") && signalMap.containsKey("Mi")) {
                    Double Mx = parseDouble(signalMap.get("Mx"));
                    Double Mi = parseDouble(signalMap.get("Mi"));
                    if (Mx != null && Mi != null) {
                        Double sub = Mx - Mi;
                        WarnQuery query = new WarnQuery();
                        query.setVid(request.getCarId());
                        query.setWid(request.getWarnId());
                        query.setSub(sub);
                        query.setType(1);
                        WarnInfo warnInfo = warnService.getWarnInfo(query);
                        if (warnInfo != null) {
                            warnInfos.add(warnInfo);
                        }
                    }
                }

                // Process "Ix - Ii"
                if (signalMap.containsKey("Ix") && signalMap.containsKey("Ii")) {
                    Double Ix = parseDouble(signalMap.get("Ix"));
                    Double Ii = parseDouble(signalMap.get("Ii"));
                    if (Ix != null && Ii != null) {
                        Double sub = Ix - Ii;
                        WarnQuery query = new WarnQuery();
                        query.setVid(request.getCarId());
                        query.setWid(request.getWarnId());
                        query.setSub(sub);
                        query.setType(2);
                        WarnInfo warnInfo = warnService.getWarnInfo(query);
                        if (warnInfo != null) {
                            warnInfos.add(warnInfo);
                        }
                    }
                }

            } catch (Exception e) {
                LOGGER.severe("Error processing request: " + e.getMessage());
                e.printStackTrace();
            }
        }

        WarnResponse response = new WarnResponse();
        response.setCode(200);
        response.setMessage("Success");
        response.setData(warnInfos);
        return response;
    }

    private Double parseDouble(Object value) {
        try {
            if (value instanceof Number) {
                return ((Number) value).doubleValue();
            } else {
                return Double.parseDouble(value.toString());
            }
        } catch (NumberFormatException e) {
            LOGGER.severe("Error parsing number: " + value);
            return null;
        }
    }
}
