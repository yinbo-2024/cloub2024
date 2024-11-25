package com.atguigu.cloub;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@SpringBootApplication
@EnableDiscoveryClient
@RefreshScope  //自动刷新注解
public class Main9002 {
    public static void main(String[] args) {
        SpringApplication.run(Main9002.class,args);
    }
}