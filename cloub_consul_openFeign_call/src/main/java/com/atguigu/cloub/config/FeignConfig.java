package com.atguigu.cloub.config;

import feign.Logger;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    // feign 请求策略 配置
    @Bean
    public Retryer myRetryer(){
//         默认 不重试策略
//        return   Retryer.NEVER_RETRY;
//        // 设置重试策略 初始间隔时间 100ms  最大间隔时间1s   最大重试次数 3(包含第一次请求次数)
        return  new Retryer.Default(100,1,3);

    }

    // feign 日志配置 打印

    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }

}
