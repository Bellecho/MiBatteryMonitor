# 文件目录
```
project-root/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           ├── MiBatteryMonitorApplication.java
│   │   │           ├── cache/
│   │   │           │   └── RedisCache.java
│   │   │           ├── controller/
│   │   │           │   └── WarnController.java
│   │   │           ├── dao/
│   │   │           │   ├── VehicleDAO.java
│   │   │           │   └── WarnRuleDAO.java
│   │   │           ├── dto/
│   │   │           │   ├── WarnRequest.java
│   │   │           │   └── WarnResponse.java
│   │   │           ├── entity/
│   │   │           │   ├── Vehicle.java
│   │   │           │   ├── WarnInfo.java
│   │   │           │   ├── WarnQuery.java
│   │   │           │   └── WarnRule.java
│   │   │           ├── service/
│   │   │           │   ├── VehicleService.java
│   │   │           │   ├── WarnService.java
│   │   │           │   └── impl/
│   │   │           │       ├── VehicleServiceImpl.java
│   │   │           │       └── WarnServiceImpl.java
│   │   │           └── unit/
│   │   │               └── ApplicationContextUtils.java
│   │   ├── resources/
│   │   │   ├── application.yml
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── mapper/
│   │   │               ├── VehicleDaoMapper.xml
│   │   │               └── WarnRuleDaoMapper.xml
│   ├── test/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── WarnControllerTest.java
│   │   │           └── WarnRuleServiceTest.java
```
### 系统设计
开发语言：Java
技术架构：SpringBoot  2.6.13
数据库：mysql 8.2.0
缓存： redis 5.0.14
测试工具：Postman（接口测试）、JMeter（性能测试）
**功能概述**
  监控电池状态，在预警规则内，判断预警等级。
**系统架构**
  表示层：主要负责接收用户请求和返回响应。采用Spring Boot的Controller类处理HTTP请求。
  业务逻辑层：负责处理具体的业务逻辑。通过Service类实现。
     数据访问层：负责与数据库进行交互。采用Mybatis框架简化数据访问操作。
