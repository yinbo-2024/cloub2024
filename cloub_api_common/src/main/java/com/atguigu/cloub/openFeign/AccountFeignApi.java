package com.atguigu.cloub.openFeign;

import com.atguigu.cloub.Exception.AccountFeignApiException;
import com.atguigu.cloub.common.ResponseResult;
import com.atguigu.cloub.entity.TAccount;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "cloub-seata-account",fallback= AccountFeignApiException.class)
public interface AccountFeignApi {

    /**
     *  根据主键id更新表t_account信息
     *  @param tAccount
     */
    @RequestMapping("/updateTAccountByid")
    public ResponseResult updateTAccountByid(@RequestBody  TAccount tAccount);
}
