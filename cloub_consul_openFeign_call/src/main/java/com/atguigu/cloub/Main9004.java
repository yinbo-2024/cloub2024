package com.atguigu.cloub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient  // 激活服务注册中心 启用注册服务
@EnableFeignClients   // 开启OpenFeign 并激活
public class Main9004 {
    public static void main(String[] args) {
        SpringApplication.run(Main9004.class,args);
    }
}