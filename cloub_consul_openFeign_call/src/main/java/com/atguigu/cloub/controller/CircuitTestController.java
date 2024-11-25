package com.atguigu.cloub.controller;

import com.atguigu.cloub.openFeign.OpenFeignApi;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CircuitTestController  {
    @Autowired
    private OpenFeignApi openFeignApi;


    /**
     *  引入 断路器 测试 接口
     * @param id
     * @return
     */
    @RequestMapping("/openFeign/circuitTest/{id}")
    @CircuitBreaker(name = "cloub-consul-dao",fallbackMethod = "myCircuitBreakFallBack")
    public  String circuitTest(@PathVariable("id") String id){
        return openFeignApi.circuit(id);
    }
    /**
     * 断路器 服务兜底  断路器兜底方法
     * @param id
     * @param throwable
     * @return
     */
    public  String myCircuitBreakFallBack(String id,Throwable throwable){
        return "系统繁忙，请稍后再试 ";
    }

}
