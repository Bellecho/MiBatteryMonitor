package com.example;

import com.example.entity.Vehicle;
import com.example.service.VehicleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest(classes = MiBatteryMonitorApplication.class)
//@ContextConfiguration(locations = {"classpath:com/example/mapper/VehicleDaoMapper.xml","classpath:com/example/mapper/WarnRuleDaoMapper.xml"})
//@RunWith(SpringJUnit4ClassRunner.class)
public class TestVehicleService {
    @Autowired
    private VehicleService vehicleService;

    @Test
    public void testAddVehicle() {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleNumber(4);
        vehicle.setBatteryType("三元电池");
        vehicle.setTotalMileage(300);
        vehicle.setBatteryHealthStatus(98);
        vehicleService.addVehicle(vehicle);
        System.out.println("添加车辆成功");
    }

    @Test
    public void testGetVehicleByNumber() {
        vehicleService.getAllVehicles().forEach(u -> System.out.println("u="+u));
    }
}
