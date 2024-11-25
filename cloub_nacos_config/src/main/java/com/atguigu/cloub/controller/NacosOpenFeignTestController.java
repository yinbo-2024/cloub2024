package com.atguigu.cloub.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.cloub.common.ResponseResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NacosOpenFeignTestController {

    // 暴漏 给外部 服务调用的接口  暴漏到 commons 包中
    @RequestMapping("/nacosOpenFeign/getValues/{id}")
    @SentinelResource(value = "nacosOpenFeign",blockHandler = "nacosOpenFeignHand")
    public ResponseResult nacosOpenFeign(@PathVariable("id") String id){
        String result=" commons - 》config  ";
        return ResponseResult.success("",result);
    }

    public ResponseResult nacosOpenFeignHand(@PathVariable("id") String id,BlockException blockException){
        return ResponseResult.success(" 点击太快，请稍等在在试！！！！");
    }
}
