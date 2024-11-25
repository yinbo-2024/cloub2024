package com.atguigu.cloub.controller;

import com.atguigu.cloub.common.ResponseResult;
import com.atguigu.cloub.openFeign.OpenFeignApi;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PayConsulController {

    @Autowired
    private OpenFeignApi openFeignApi;

    /**
     *  对外暴露 的 对外 查询单个对象的接口
     * @param id
     * @return
     */
    @RequestMapping("/openFeign/getUser/{id}")
    public ResponseResult getInfo(@PathVariable("id") String id){
      return  openFeignApi.findUser2024Byid(id);
    }

    /**
     *  校验 对外 暴露 的 负载均衡接口
     * @return
     */
    @RequestMapping("/openFeign/getConsulLb")
    public String getInfo(){
        return  openFeignApi.getLb();
    }

    /**
     *  OpenFeign  超时时间 测试
     * @param id
     * @return
     */
    @RequestMapping("/openFeign/findUsersById/{id}")
    public ResponseResult findUsers(@PathVariable("id") String id){
        return openFeignApi.findUsersById(id);
    }



}
