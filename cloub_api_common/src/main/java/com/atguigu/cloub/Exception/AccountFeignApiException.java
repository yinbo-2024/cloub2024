package com.atguigu.cloub.Exception;

import com.atguigu.cloub.common.ResponseResult;
import com.atguigu.cloub.entity.TAccount;
import com.atguigu.cloub.openFeign.AccountFeignApi;
import org.springframework.stereotype.Component;

@Component
public class AccountFeignApiException implements AccountFeignApi {
    @Override
    public ResponseResult updateTAccountByid(TAccount tAccount) {
        return ResponseResult.fail(" 当前请求 有误，请稍后在试！！！！");
    }
}
