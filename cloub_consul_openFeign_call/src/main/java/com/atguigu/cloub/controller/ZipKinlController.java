package com.atguigu.cloub.controller;

import com.atguigu.cloub.common.ResponseResult;
import com.atguigu.cloub.openFeign.OpenFeignApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ZipKinlController {

    @Autowired
    private OpenFeignApi openFeignApi;


    /**
     *  校验 对外 暴露 的 负载均衡接口
     * @return
     */
    @RequestMapping("/openFeign/zipkin/getId/{id}")
    public String getZipKin(@PathVariable("id") String id){
        return  openFeignApi.getZipKin(id);
    }



}
