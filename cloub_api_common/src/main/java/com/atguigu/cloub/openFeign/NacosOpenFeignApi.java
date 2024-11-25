package com.atguigu.cloub.openFeign;

import com.atguigu.cloub.Exception.SentinelException;
import com.atguigu.cloub.common.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "cloub-nacos-config",fallback=SentinelException.class)
public interface NacosOpenFeignApi {

    @RequestMapping("/nacosOpenFeign/getValues/{id}")
    public ResponseResult nacosOpenFeign(@PathVariable("id") String id);
}
