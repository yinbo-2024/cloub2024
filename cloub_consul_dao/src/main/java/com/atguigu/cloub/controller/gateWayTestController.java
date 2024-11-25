package com.atguigu.cloub.controller;

import cn.hutool.core.date.DateUtil;
import com.atguigu.cloub.common.ResponseResult;
import com.atguigu.cloub.service.User2024Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;


@RestController
public class gateWayTestController {

    @Autowired
    private User2024Service user2024Service;

    /**
     * 根据主键id查询表user2024信息
     *
     * @param id
     */
    @RequestMapping("/gateway/gateway2024Byid/{id}")
    public ResponseResult gateway2024Byid(@PathVariable("id") String id) {
        return ResponseResult.success(user2024Service.findUser2024Byid(id));
    }

    /**
     * 请求头测试
     */
    @RequestMapping("/gateway/gatewayHead/filter")
    public ResponseResult gateWaysRequestHeadTest(HttpServletRequest httpServletRequest) {
        String result="";
        Enumeration<String> heads=httpServletRequest.getHeaderNames();
        while (heads.hasMoreElements()){
            String headName=heads.nextElement();
            String headValue=httpServletRequest.getHeader(headName);
            System.out.println("请求头是："+headName+"\t"+ "请求头的值是："+headValue);
            if(headName.equalsIgnoreCase("X-Request-yin")
                    || headName.equalsIgnoreCase("X-Request-bo")){
                result=result+headName+"\t "+headValue;
            }

        }
        String resultStr="gateWay 的Filter test 是："+result+" "+DateUtil.now();
        return ResponseResult.success("",resultStr);
    }


}



