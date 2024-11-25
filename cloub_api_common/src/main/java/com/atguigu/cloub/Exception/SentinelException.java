package com.atguigu.cloub.Exception;

import com.atguigu.cloub.common.ResponseResult;
import com.atguigu.cloub.openFeign.NacosOpenFeignApi;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

@Component
public class SentinelException implements NacosOpenFeignApi {
    @Override
    public ResponseResult nacosOpenFeign(@PathVariable("id") String id) {
        return ResponseResult.fail(" 当前请求 有误，请稍后在试！！！！");
    }
}
