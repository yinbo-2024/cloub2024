package com.atguigu.cloub.openFeign;

import com.atguigu.cloub.Exception.OrderFeignApiException;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "cloub-seata-order",fallback= OrderFeignApiException.class)
public interface OrderFeignApi {

}
