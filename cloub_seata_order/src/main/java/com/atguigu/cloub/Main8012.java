package com.atguigu.cloub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@SpringBootApplication
@EnableDiscoveryClient // 注册到 nacos
@EnableFeignClients   // 开启OpenFeign 并激活
public class Main8012 {
    public static void main(String[] args) {
        SpringApplication.run(Main8012.class,args);
    }
}