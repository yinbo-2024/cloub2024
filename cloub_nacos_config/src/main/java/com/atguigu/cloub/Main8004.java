package com.atguigu.cloub;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class Main8004 {
    public static void main(String[] args) {
        SpringApplication.run(Main8004.class,args);
        }
}
