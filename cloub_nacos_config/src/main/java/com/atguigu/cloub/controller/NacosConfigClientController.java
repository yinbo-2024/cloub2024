package com.atguigu.cloub.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope  // 动态刷新 注解 动态通知
public class NacosConfigClientController {

    @RequestMapping("/get/nacos/ConfigInfo")
    public String getConfigInfo(@Value("${atguigu.info}") String configInfo){
        return "configInfo:===="+configInfo;
    }




}
