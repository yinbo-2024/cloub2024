package com.atguigu.cloub.openFeign;

import com.atguigu.cloub.Exception.SentinelException;
import com.atguigu.cloub.Exception.StroageFeignApiException;
import com.atguigu.cloub.common.ResponseResult;
import com.atguigu.cloub.entity.TAccount;
import com.atguigu.cloub.entity.TStorage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "cloub-seata-stroage",fallback= StroageFeignApiException.class)
public interface StroageFeignApi {

    /**
     *  根据主键id更新表t_storage信息
     *  @param tStorage
     */
    @RequestMapping("/updateTStorageByid")
    public ResponseResult updateTStorageByid(@RequestBody TStorage tStorage);
}
