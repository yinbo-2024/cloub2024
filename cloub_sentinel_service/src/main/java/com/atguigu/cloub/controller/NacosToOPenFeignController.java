package com.atguigu.cloub.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.cloub.common.ResponseResult;
import com.atguigu.cloub.openFeign.NacosOpenFeignApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class NacosToOPenFeignController {
    /**
     * 注入 commons 对外暴漏 接口
     */
    @Autowired
   private NacosOpenFeignApi nacosOpenFeignApi;

    @RequestMapping("/nacosOpenFeign/getValues/{id}")
    @SentinelResource(value = "getOpenInfo",blockHandler = "BlockHands")
    public ResponseResult getOpenInfo(@PathVariable("id") String id){
        System.out.println("serve ->>>>>> commons");
        return  nacosOpenFeignApi.nacosOpenFeign(id);
    }

    public ResponseResult BlockHands(@PathVariable("id") String id,BlockException blockExceptionk){
        return ResponseResult.fail(" 目前请求数量过多，请稍后重试！！！！");
    }


}
