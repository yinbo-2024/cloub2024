package com.atguigu.cloub.Exception;

import com.atguigu.cloub.common.ResponseResult;
import com.atguigu.cloub.entity.TStorage;
import com.atguigu.cloub.openFeign.StroageFeignApi;
import org.springframework.stereotype.Component;

@Component
public class StroageFeignApiException implements StroageFeignApi {
    @Override
    public ResponseResult updateTStorageByid(TStorage tStorage) {
        return ResponseResult.fail(" 当前请求 有误，请稍后在试！！！！");
    }
}
