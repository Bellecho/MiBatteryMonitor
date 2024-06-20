package com.example.unit;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

//用于获取springboot创建好的工厂
@Component
public class ApplicationContextUtils implements ApplicationContextAware {

    //定义一个静态变量，用于保存创建好的工厂
    private static ApplicationContext applicationContext;

    //将创建好的工厂以参数形式传递给这个类
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
    //提供在工厂中获取对象的方法
    public static Object getBean(String beanName) {
        return applicationContext.getBean(beanName);
    }
}

