package com.atguigu.cloub.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.atguigu.cloub.service.Sentinel;
import org.springframework.stereotype.Service;

@Service
public class SentinelImpl implements Sentinel {
    @Override
    @SentinelResource(value = "commons")
    public String getCommmens() {
        String result=" 调成功了";
        return  result;
    }
}
